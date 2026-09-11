package com.dong.servicelock;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: 分布式锁 锁类型
 * @author Dong
 **/
public enum LockType {
    /**
     * 锁类型
     */
    Reentrant,
    
    Fair,
   
    Read,
    
    Write;

    LockType() {
    }

}
