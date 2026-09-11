package com.dong.kafka.consumer;

import io.micrometer.core.instrument.MeterRegistry;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import com.dong.cache.SeckillVoucherLocalCache;
import com.dong.consumer.AbstractConsumerHandler;
import com.dong.core.RedisKeyManage;
import com.dong.kafka.message.SeckillVoucherInvalidationMessage;
import com.dong.message.MessageExtend;
import com.dong.redis.RedisCache;
import com.dong.redis.RedisKeyBuild;
import com.dong.servicelock.LockType;
import com.dong.servicelock.annotion.ServiceLock;
import org.springframework.aop.framework.AopContext;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;

import static com.dong.constant.Constant.SECKILL_VOUCHER_CACHE_INVALIDATION_TOPIC;
import static com.dong.constant.Constant.SPRING_INJECT_PREFIX_DISTINCTION_NAME;
import static com.dong.constant.DistributedLockConstants.UPDATE_SECKILL_VOUCHER_LOCK;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: Kafka 消费者：接收“秒杀券缓存失效”广播
 * @author Dong
 **/
@Slf4j
@Component
public class SeckillVoucherInvalidationConsumer extends AbstractConsumerHandler<SeckillVoucherInvalidationMessage> {


    @Resource
    private SeckillVoucherLocalCache seckillVoucherLocalCache;
    
    @Resource
    private MeterRegistry meterRegistry;


    @Resource
    private RedisCache redisCache;

    public SeckillVoucherInvalidationConsumer() {
        super(SeckillVoucherInvalidationMessage.class);
    }
    
    @KafkaListener(
            topics = {SPRING_INJECT_PREFIX_DISTINCTION_NAME + "-" + SECKILL_VOUCHER_CACHE_INVALIDATION_TOPIC},
            groupId = "${prefix.distinction.name:dzdp}-seckill_voucher_cache_invalidation-${random.uuid}"
    )
    public void onMessage(String value,
                          @Headers Map<String, Object> headers,
                          @Header(name = KafkaHeaders.RECEIVED_KEY, required = false) String key,
                          Acknowledgment acknowledgment) {
        consumeRaw(value, key, headers);
        if (acknowledgment != null) {
            acknowledgment.acknowledge();
        }
    }
    
    @Override
    protected void doConsume(MessageExtend<SeckillVoucherInvalidationMessage> message) {
        SeckillVoucherInvalidationMessage body = message.getMessageBody();
        if (Objects.isNull(body.getVoucherId())) {
            log.warn("收到缓存失效消息但载荷为空或voucherId缺失, uuid={}", message.getUuid());
            return;
        }
        Long voucherId = body.getVoucherId();
        
        ((SeckillVoucherInvalidationConsumer) AopContext.currentProxy()).delCache(voucherId);
    }
    
    @ServiceLock(lockType= LockType.Write,name = UPDATE_SECKILL_VOUCHER_LOCK,keys = {"#voucherId"})
    public void delCache(Long voucherId){
        RedisKeyBuild seckillVoucherRedisKey =
                RedisKeyBuild.createRedisKey(RedisKeyManage.SECKILL_VOUCHER_TAG_KEY, voucherId);
        seckillVoucherLocalCache.invalidate(seckillVoucherRedisKey.getRelKey());
        
        redisCache.del(RedisKeyBuild.createRedisKey(RedisKeyManage.SECKILL_VOUCHER_TAG_KEY, voucherId));
        redisCache.del(RedisKeyBuild.createRedisKey(RedisKeyManage.SECKILL_STOCK_TAG_KEY, voucherId));
        redisCache.del(RedisKeyBuild.createRedisKey(RedisKeyManage.SECKILL_VOUCHER_NULL_TAG_KEY, voucherId));
        
    }
    
    @Override
    protected void afterConsumeFailure(final MessageExtend<SeckillVoucherInvalidationMessage> message, final Throwable throwable) {
        super.afterConsumeFailure(message, throwable);
        log.warn("删除Redis缓存失败 voucherId={}", message.getMessageBody().getVoucherId(), throwable);
        safeInc(errorTag(throwable));
    }
    
    private void safeInc(String tagValue) {
        try {
            if (meterRegistry != null) {
                meterRegistry.counter("seckill_invalidation_consume_failures", "error", tagValue).increment();
            }
        } catch (Exception ignore) {
        }
    }

    private String errorTag(Throwable t) {
        return t == null ? "unknown" : t.getClass().getSimpleName();
    }
}
