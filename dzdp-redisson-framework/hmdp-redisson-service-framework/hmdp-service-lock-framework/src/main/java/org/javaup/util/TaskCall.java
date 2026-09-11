package com.dong.util;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: 分布式锁 方法类型执行 有返回值的业务
 * @author Dong
 **/
@FunctionalInterface
public interface TaskCall<V> {

    /**
     * 执行任务
     * @return 结果
     * */
    V call();
}
