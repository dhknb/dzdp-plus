package com.dong.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dong.entity.SeckillVoucher;
import com.dong.model.SeckillVoucherFullModel;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: 秒杀优惠券 接口
 * @author Dong
 **/
public interface ISeckillVoucherService extends IService<SeckillVoucher> {
    
    SeckillVoucherFullModel queryByVoucherId(Long voucherId);
    
    void loadVoucherStock(Long voucherId);
    
    boolean rollbackStock(Long voucherId);
}
