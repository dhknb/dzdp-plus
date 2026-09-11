package com.dong.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: 取消优惠券订单
 * @author Dong
 **/
@Data
@EqualsAndHashCode(callSuper = false)
public class CancelVoucherOrderDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    
    /**
     * 优惠券id
     * */
    @NotNull
    private Long voucherId;

}
