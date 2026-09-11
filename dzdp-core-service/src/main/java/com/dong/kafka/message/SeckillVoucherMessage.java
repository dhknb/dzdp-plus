package com.dong.kafka.message;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: 秒杀券消息
 * @author Dong
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeckillVoucherMessage {

    private Long userId;
    
    private Long voucherId;
    
    private Long orderId;

    private Long traceId;

    private Integer beforeQty;
    
    private Integer changeQty;
    
    private Integer afterQty;
    
    private Boolean autoIssue;
}
