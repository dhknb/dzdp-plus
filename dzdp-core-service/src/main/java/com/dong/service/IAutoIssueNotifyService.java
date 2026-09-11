package com.dong.service;


/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: 自动发券成功后的用户通知服务接口
 * @author Dong
 **/
public interface IAutoIssueNotifyService {
    
    void sendAutoIssueNotify(Long voucherId, Long userId, Long orderId);
}