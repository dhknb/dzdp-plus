package com.dong.servicelock.annotion;

import com.dong.servicelock.LockType;
import com.dong.servicelock.info.LockTimeOutStrategy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: 注解
 * @author Dong
 **/
@Target(value= {ElementType.TYPE, ElementType.METHOD})
@Retention(value= RetentionPolicy.RUNTIME)
public @interface ServiceLock {
    
    LockType lockType() default LockType.Reentrant;
    
    String name() default "";
   
    String [] keys();
    
    long waitTime() default 10;
    
    TimeUnit timeUnit() default TimeUnit.SECONDS;
    
    LockTimeOutStrategy lockTimeoutStrategy() default LockTimeOutStrategy.FAIL;
    
    String customLockTimeoutStrategy() default "";
}
