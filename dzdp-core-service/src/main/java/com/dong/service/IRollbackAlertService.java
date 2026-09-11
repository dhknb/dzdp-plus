package com.dong.service;

import com.dong.entity.RollbackFailureLog;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: 回滚失败通知服务：用于发送短信/邮件告警（可插拔实现）。
 * @author Dong
 **/
public interface IRollbackAlertService {

    void sendRollbackAlert(RollbackFailureLog log);
}