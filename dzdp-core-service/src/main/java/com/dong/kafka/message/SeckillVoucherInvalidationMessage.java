package com.dong.kafka.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: 秒杀券缓存失效广播消息
 * @author Dong
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeckillVoucherInvalidationMessage {
    
    private Long voucherId;
    
    private String reason;
}