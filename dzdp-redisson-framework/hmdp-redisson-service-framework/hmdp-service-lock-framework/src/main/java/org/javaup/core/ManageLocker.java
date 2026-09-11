package com.dong.core;

import com.dong.servicelock.LockType;
import com.dong.servicelock.ServiceLocker;
import com.dong.servicelock.impl.RedissonFairLocker;
import com.dong.servicelock.impl.RedissonReadLocker;
import com.dong.servicelock.impl.RedissonReentrantLocker;
import com.dong.servicelock.impl.RedissonWriteLocker;
import org.redisson.api.RedissonClient;

import java.util.HashMap;
import java.util.Map;

import static com.dong.servicelock.LockType.Fair;
import static com.dong.servicelock.LockType.Read;
import static com.dong.servicelock.LockType.Reentrant;
import static com.dong.servicelock.LockType.Write;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: 缓存
 * @author Dong
 **/
public class ManageLocker {

    private final Map<LockType, ServiceLocker> cacheLocker = new HashMap<>();
    
    public ManageLocker(RedissonClient redissonClient){
        cacheLocker.put(Reentrant,new RedissonReentrantLocker(redissonClient));
        cacheLocker.put(Fair,new RedissonFairLocker(redissonClient));
        cacheLocker.put(Write,new RedissonWriteLocker(redissonClient));
        cacheLocker.put(Read,new RedissonReadLocker(redissonClient));
    }
    
    public ServiceLocker getReentrantLocker(){
        return cacheLocker.get(Reentrant);
    }
    
    public ServiceLocker getFairLocker(){
        return cacheLocker.get(Fair);
    }
    
    public ServiceLocker getWriteLocker(){
        return cacheLocker.get(Write);
    }
    
    public ServiceLocker getReadLocker(){
        return cacheLocker.get(Read);
    }
}
