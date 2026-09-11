package com.dong.servicelock.info;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: 处理失败抽象
 * @author Dong
 **/
public interface LockTimeOutHandler {
    
    /**
     * 处理
     * @param lockName 锁名
     * */
    void handler(String lockName);
}
