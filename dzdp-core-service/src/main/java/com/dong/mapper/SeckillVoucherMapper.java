package com.dong.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import com.dong.entity.SeckillVoucher;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: 秒杀优惠券表，与优惠券是一对一关系 Mapper
 * @author Dong
 **/
public interface SeckillVoucherMapper extends BaseMapper<SeckillVoucher> {
   
    @Update("UPDATE tb_seckill_voucher SET stock = stock + 1,update_time = NOW() WHERE voucher_id = #{voucherId}")
    Integer rollbackStock(@Param("voucherId")Long voucherId);

}
