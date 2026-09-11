package com.dong.config;

import com.dong.constant.LockInfoType;
import com.dong.handle.RedissonDataHandle;
import com.dong.locallock.LocalLockCache;
import com.dong.lockinfo.LockInfoHandle;
import com.dong.lockinfo.factory.LockInfoHandleFactory;
import com.dong.lockinfo.impl.RepeatExecuteLimitLockInfoHandle;
import com.dong.repeatexecutelimit.aspect.RepeatExecuteLimitAspect;
import com.dong.servicelock.factory.ServiceLockFactory;
import org.springframework.context.annotation.Bean;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: 配置
 * @author Dong
 **/
public class RepeatExecuteLimitAutoConfiguration {
    
    @Bean(LockInfoType.REPEAT_EXECUTE_LIMIT)
    public LockInfoHandle repeatExecuteLimitHandle(){
        return new RepeatExecuteLimitLockInfoHandle();
    }
    
    @Bean
    public RepeatExecuteLimitAspect repeatExecuteLimitAspect(LocalLockCache localLockCache,
                                                             LockInfoHandleFactory lockInfoHandleFactory,
                                                             ServiceLockFactory serviceLockFactory,
                                                             RedissonDataHandle redissonDataHandle){
        return new RepeatExecuteLimitAspect(localLockCache, lockInfoHandleFactory,serviceLockFactory,redissonDataHandle);
    }
}
    