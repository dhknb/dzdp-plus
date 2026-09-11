package com.dong.model;

import lombok.Data;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: redis 中的记录日志信息
 * @author Dong
 **/
@Data
public class RedisTraceLogModel {

    private String logType;
    
    private Long ts;
    
    private String orderId;
    
    private String traceId;
    
    private String userId;
    
    private String voucherId;
    
    private Integer beforeQty;
    
    private Integer changeQty;
    
    private Integer afterQty;
}
