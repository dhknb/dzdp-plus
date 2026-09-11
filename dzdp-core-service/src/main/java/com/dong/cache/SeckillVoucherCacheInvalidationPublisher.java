package com.dong.cache;

import jakarta.annotation.Resource;
import com.dong.core.RedisKeyManage;
import com.dong.kafka.message.SeckillVoucherInvalidationMessage;
import com.dong.kafka.producer.SeckillVoucherInvalidationProducer;
import com.dong.redis.RedisCache;
import com.dong.redis.RedisKeyBuild;
import com.dong.core.SpringUtil;
import org.springframework.stereotype.Component;

import static com.dong.constant.Constant.SECKILL_VOUCHER_CACHE_INVALIDATION_TOPIC;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: 业务发布入口：触发秒杀券缓存失效广播
 * @author Dong
 **/
@Component
public class SeckillVoucherCacheInvalidationPublisher {

    @Resource
    private RedisCache redisCache;
    
    @Resource
    private SeckillVoucherInvalidationProducer invalidationProducer;
    
    @Resource
    private SeckillVoucherLocalCache seckillVoucherLocalCache;
    
    public void publishInvalidate(Long voucherId, String reason) {
        RedisKeyBuild seckillVoucherRedisKey =
                RedisKeyBuild.createRedisKey(RedisKeyManage.SECKILL_VOUCHER_TAG_KEY, voucherId);
        seckillVoucherLocalCache.invalidate(seckillVoucherRedisKey.getRelKey());
        redisCache.del(RedisKeyBuild.createRedisKey(RedisKeyManage.SECKILL_VOUCHER_TAG_KEY, voucherId));
        redisCache.del(RedisKeyBuild.createRedisKey(RedisKeyManage.SECKILL_STOCK_TAG_KEY, voucherId));
        redisCache.del(RedisKeyBuild.createRedisKey(RedisKeyManage.SECKILL_VOUCHER_NULL_TAG_KEY, voucherId));
        
        SeckillVoucherInvalidationMessage payload = new SeckillVoucherInvalidationMessage(voucherId, reason);
        invalidationProducer.sendPayload(
                SpringUtil.getPrefixDistinctionName() + "-" + SECKILL_VOUCHER_CACHE_INVALIDATION_TOPIC,
                payload
        );
    }
}