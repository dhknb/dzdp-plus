package com.dong.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: 优惠券订阅批量查询
 * @author Dong
 **/
@Data
@EqualsAndHashCode(callSuper = false)
public class VoucherSubscribeBatchDto implements Serializable {
    
    @Serial
    private static final long serialVersionUID = 1L;
    
    /**
     * 优惠券id集合
     * */
    @NotNull
    private List<Long> voucherIdList;
}
