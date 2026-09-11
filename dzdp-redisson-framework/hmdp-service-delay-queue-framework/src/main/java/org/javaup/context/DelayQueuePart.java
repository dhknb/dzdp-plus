package com.dong.context;

import com.dong.core.ConsumerTask;
import lombok.Data;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: 消息主题
 * @author Dong
 **/
@Data
public class DelayQueuePart {
    
    private final DelayQueueBasePart delayQueueBasePart;
 
    private final ConsumerTask consumerTask;
    
    public DelayQueuePart(DelayQueueBasePart delayQueueBasePart, ConsumerTask consumerTask){
        this.delayQueueBasePart = delayQueueBasePart;
        this.consumerTask = consumerTask;
    }
}
