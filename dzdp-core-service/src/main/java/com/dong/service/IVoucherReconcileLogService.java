package com.dong.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dong.dto.VoucherReconcileLogDto;
import com.dong.entity.VoucherReconcileLog;
import com.dong.kafka.message.SeckillVoucherMessage;
import com.dong.message.MessageExtend;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: 对账日志 接口
 * @author Dong
 **/
public interface IVoucherReconcileLogService extends IService<VoucherReconcileLog> {
    
    boolean saveReconcileLog(Integer logType,
                             Integer businessType,
                             String detail,
                             MessageExtend<SeckillVoucherMessage> message);
    
    boolean saveReconcileLog(Integer logType,
                             Integer businessType,
                             String detail,
                             Long traceId,
                             MessageExtend<SeckillVoucherMessage> message);
    
    
    boolean saveReconcileLog(VoucherReconcileLogDto voucherReconcileLogDto);
}