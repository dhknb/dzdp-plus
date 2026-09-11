package com.dong.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dong.dto.GetVoucherOrderRouterDto;
import com.dong.entity.VoucherOrderRouter;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: 优惠券订单路由 接口
 * @author Dong
 **/
public interface IVoucherOrderRouterService extends IService<VoucherOrderRouter> {
    
    Long get(GetVoucherOrderRouterDto getVoucherOrderRouterDto);
}
