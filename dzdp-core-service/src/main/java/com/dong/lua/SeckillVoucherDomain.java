package com.dong.lua;

import lombok.Data;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: lua秒杀返回数据
 * @author Dong
 **/
@Data
public class SeckillVoucherDomain {

    private Integer code;
    
    private Integer beforeQty;
    
    private Integer deductQty;
    
    private Integer afterQty;

}
