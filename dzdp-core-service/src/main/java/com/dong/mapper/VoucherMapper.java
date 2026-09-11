package com.dong.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dong.entity.Voucher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: 优惠券 Mapper
 * @author Dong
 **/
public interface VoucherMapper extends BaseMapper<Voucher> {

    List<Voucher> queryVoucherOfShop(@Param("shopId") Long shopId);
}
