package com.dong.handle;

import lombok.AllArgsConstructor;
import org.redisson.api.RedissonClient;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: redisson操作
 * @author Dong
 **/
@AllArgsConstructor
public class RedissonDataHandle {
    
    private final RedissonClient redissonClient;
    
    public String get(String key){
        return (String)redissonClient.getBucket(key).get();
    }
    
    public void set(String key,String value){
        redissonClient.getBucket(key).set(value);
    }
    
    public void set(String key,String value,long timeToLive, TimeUnit timeUnit){
        redissonClient.getBucket(key).set(value,getDuration(timeToLive,timeUnit));
    }
    
    public Duration getDuration(long timeToLive, TimeUnit timeUnit){
        switch (timeUnit) {
            
            case MINUTES -> {
                return Duration.ofMinutes(timeToLive);
            }
            
            case HOURS -> {
                return Duration.ofHours(timeToLive);
            }
            
            case DAYS -> {
                return Duration.ofDays(timeToLive);
            }
            
            default -> {
                return Duration.ofSeconds(timeToLive);
            }
        }
    }
}
