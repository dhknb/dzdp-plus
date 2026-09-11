package com.dong.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: 优惠券订单
 * @author Dong
 **/
@Data
@EqualsAndHashCode(callSuper = false)
public class VoucherOrderDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 下单的用户id
     */
    private Long userId;

    /**
     * 购买的代金券id
     */
    private Long voucherId;
    
    private String messageId;
    
    private Boolean autoIssue;

}
