package com.dong.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: 修改优惠券库存
 * @author Dong
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UpdateSeckillVoucherStockDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 优惠券id
     */
    @NotNull
    private Long voucherId;
    
    /**
     * 初始库存
     * */
    @Min(1)
    @NotNull
    private Integer initStock;
}
