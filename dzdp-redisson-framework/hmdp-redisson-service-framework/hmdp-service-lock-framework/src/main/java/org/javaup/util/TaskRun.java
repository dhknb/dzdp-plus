package com.dong.util;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: 分布式锁 方法类型执行 无返回值的业务
 * @author Dong
 **/
@FunctionalInterface
public interface TaskRun {
    
    /**
     * 执行任务
     * */
    void run();
}
