package com.dong.config;

import com.dong.constant.LockInfoType;
import com.dong.core.ManageLocker;
import com.dong.lockinfo.LockInfoHandle;
import com.dong.lockinfo.factory.LockInfoHandleFactory;
import com.dong.lockinfo.impl.ServiceLockInfoHandle;
import com.dong.servicelock.aspect.ServiceLockAspect;
import com.dong.servicelock.factory.ServiceLockFactory;
import com.dong.util.ServiceLockTool;
import org.redisson.api.RedissonClient;
import org.springframework.context.annotation.Bean;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: 配置
 * @author Dong
 **/
public class ServiceLockAutoConfiguration {
    
    @Bean(LockInfoType.SERVICE_LOCK)
    public LockInfoHandle serviceLockInfoHandle(){
        return new ServiceLockInfoHandle();
    }
    
    @Bean
    public ManageLocker manageLocker(RedissonClient redissonClient){
        return new ManageLocker(redissonClient);
    }
    
    @Bean
    public ServiceLockFactory serviceLockFactory(ManageLocker manageLocker){
        return new ServiceLockFactory(manageLocker);
    }
    
    @Bean
    public ServiceLockAspect serviceLockAspect(LockInfoHandleFactory lockInfoHandleFactory,ServiceLockFactory serviceLockFactory){
        return new ServiceLockAspect(lockInfoHandleFactory,serviceLockFactory);
    }
    
    @Bean
    public ServiceLockTool serviceLockTooL(LockInfoHandleFactory lockInfoHandleFactory,ServiceLockFactory serviceLockFactory){
        return new ServiceLockTool(lockInfoHandleFactory,serviceLockFactory);
    }
}
