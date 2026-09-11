package com.dong.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: redis配置
 * @author Dong
 **/
public class RedisFrameWorkAutoConfig {

    @Bean("redisToolRedisTemplate")
    public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setDefaultSerializer(new StringRedisSerializer());
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }

    @Primary
    @Bean("redisToolStringRedisTemplate")
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        StringRedisTemplate myStringRedisTemplate = new StringRedisTemplate();
        myStringRedisTemplate.setDefaultSerializer(new StringRedisSerializer());
        myStringRedisTemplate.setConnectionFactory(redisConnectionFactory);
        return myStringRedisTemplate;
    }
}
