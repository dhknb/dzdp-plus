package com.dong.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dong.dto.CancelVoucherOrderDto;
import com.dong.dto.GetVoucherOrderByVoucherIdDto;
import com.dong.dto.GetVoucherOrderDto;
import com.dong.dto.Result;
import com.dong.entity.VoucherOrder;
import com.dong.kafka.message.SeckillVoucherMessage;
import com.dong.message.MessageExtend;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: 优惠券订单 接口
 * @author Dong
 **/
public interface IVoucherOrderService extends IService<VoucherOrder> {

    Result<Long> seckillVoucher(Long voucherId);

    void createVoucherOrderV1(VoucherOrder voucherOrder);
    
    boolean createVoucherOrderV2(MessageExtend<SeckillVoucherMessage> message);
    
    Long getSeckillVoucherOrder(GetVoucherOrderDto getVoucherOrderDto);
    
    Boolean cancel(CancelVoucherOrderDto cancelVoucherOrderDto);
    
    boolean autoIssueVoucherToEarliestSubscriber(final Long voucherId, final Long excludeUserId);
    
    Long getSeckillVoucherOrderIdByVoucherId(GetVoucherOrderByVoucherIdDto getVoucherOrderByVoucherIdDto);
}
