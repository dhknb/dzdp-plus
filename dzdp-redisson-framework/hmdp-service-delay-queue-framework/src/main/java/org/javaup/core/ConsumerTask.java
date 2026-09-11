package com.dong.core;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: 延迟队列 消费者接口
 * @author Dong
 **/
public interface ConsumerTask {
    
    void execute(String content);
  
    String topic();
}
