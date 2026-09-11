package com.dong.service;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: 对账执行 接口
 * @author Dong
 **/
public interface IReconciliationTaskService {
    
    void reconciliationTaskExecute();

    /**
     * 删除指定券的 Redis 库存键，触发按需重载。
     */
    void delRedisStock(Long voucherId);
}
