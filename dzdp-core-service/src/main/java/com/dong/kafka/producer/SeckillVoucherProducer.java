package com.dong.kafka.producer;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import com.dong.AbstractProducerHandler;
import com.dong.enums.SeckillVoucherOrderOperate;
import com.dong.kafka.message.SeckillVoucherMessage;
import com.dong.kafka.redis.RedisVoucherData;
import com.dong.message.MessageExtend;
import com.dong.toolkit.SnowflakeIdGenerator;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: Kafka 生产者：发送秒杀券
 * @author Dong
 **/
@Slf4j
@Component
public class SeckillVoucherProducer extends AbstractProducerHandler<MessageExtend<SeckillVoucherMessage>> {
    
    @Resource
    private SnowflakeIdGenerator snowflakeIdGenerator;
    
    
    @Resource
    private RedisVoucherData redisVoucherData;
    
    public SeckillVoucherProducer(final KafkaTemplate<String,MessageExtend<SeckillVoucherMessage>> kafkaTemplate) {
        super(kafkaTemplate);
    }
    
    @Override
    protected void afterSendFailure(final String topic, final MessageExtend<SeckillVoucherMessage> message, final Throwable throwable) {
        super.afterSendFailure(topic, message, throwable);
        long traceId = snowflakeIdGenerator.nextId();
        redisVoucherData.rollbackRedisVoucherData(
                SeckillVoucherOrderOperate.YES,
                traceId,
                message.getMessageBody().getVoucherId(),
                message.getMessageBody().getUserId(),
                message.getMessageBody().getOrderId(),
                message.getMessageBody().getAfterQty(),
                message.getMessageBody().getChangeQty(),
                message.getMessageBody().getBeforeQty());
    }
}
