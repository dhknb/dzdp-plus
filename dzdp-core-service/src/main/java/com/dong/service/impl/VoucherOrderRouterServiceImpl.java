package com.dong.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import com.dong.dto.GetVoucherOrderRouterDto;
import com.dong.entity.VoucherOrderRouter;
import com.dong.mapper.VoucherOrderRouterMapper;
import com.dong.service.IVoucherOrderRouterService;
import com.dong.utils.UserHolder;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: 优惠券订单路由实现 接口
 * @author Dong
 **/
@Slf4j
@Service
public class VoucherOrderRouterServiceImpl extends ServiceImpl<VoucherOrderRouterMapper, VoucherOrderRouter> implements IVoucherOrderRouterService {
    
    @Override
    public Long get(GetVoucherOrderRouterDto getVoucherOrderRouterDto) {
        VoucherOrderRouter voucherOrderRouter = lambdaQuery()
                .eq(VoucherOrderRouter::getUserId,  UserHolder.getUser().getId())
                .eq(VoucherOrderRouter::getVoucherId, getVoucherOrderRouterDto.getVoucherId())
                .one();
        if (Objects.nonNull(voucherOrderRouter)) {
            return voucherOrderRouter.getOrderId();
        }
        return null;
    }
}
