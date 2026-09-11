package com.dong.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dong.dto.DelayVoucherReminderDto;
import com.dong.dto.Result;
import com.dong.dto.SeckillVoucherDto;
import com.dong.dto.UpdateSeckillVoucherDto;
import com.dong.dto.UpdateSeckillVoucherStockDto;
import com.dong.dto.VoucherDto;
import com.dong.dto.VoucherSubscribeBatchDto;
import com.dong.dto.VoucherSubscribeDto;
import com.dong.entity.Voucher;
import com.dong.vo.GetSubscribeStatusVo;

import java.util.List;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: 优惠券 接口
 * @author Dong
 **/
public interface IVoucherService extends IService<Voucher> {

    Long addVoucher(VoucherDto voucherDto);
    
    Result<List<Voucher>> queryVoucherOfShop(Long shopId);

    Long addSeckillVoucher(SeckillVoucherDto seckillVoucherDto);
    
    void updateSeckillVoucher(UpdateSeckillVoucherDto updateSeckillVoucherDto);
    
    void updateSeckillVoucherStock(UpdateSeckillVoucherStockDto updateSeckillVoucherDto);
    
    void subscribe(VoucherSubscribeDto voucherSubscribeDto);
    
    void unsubscribe(VoucherSubscribeDto voucherSubscribeDto);
    
    Integer getSubscribeStatus(VoucherSubscribeDto voucherSubscribeDto);
    
    List<GetSubscribeStatusVo> getSubscribeStatusBatch(VoucherSubscribeBatchDto voucherSubscribeBatchDto);
    
    void delayVoucherReminder(DelayVoucherReminderDto delayVoucherReminderDto);
}
