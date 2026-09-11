package com.dong.lockinfo;

import org.aspectj.lang.JoinPoint;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: 锁信息抽象
 * @author Dong
 **/
public interface LockInfoHandle {
   
    String getLockName(JoinPoint joinPoint, String name, String[] keys);
    
    String simpleGetLockName(String name,String[] keys);
}
