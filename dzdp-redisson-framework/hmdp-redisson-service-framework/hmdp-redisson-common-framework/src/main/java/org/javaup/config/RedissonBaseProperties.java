package com.dong.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.concurrent.TimeUnit;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: redisson属性配置
 * @author Dong
 **/
@Data
@ConfigurationProperties(prefix = "spring.redis.redisson")
public class RedissonBaseProperties {

    private Integer threads = 16;
    
    private Integer nettyThreads = 32;
    
    private Integer corePoolSize = null;
   
    private Integer maximumPoolSize = null;
    
    private long keepAliveTime = 30;
    
    private TimeUnit unit = TimeUnit.SECONDS;
  
    private Integer workQueueSize = 256; 
}
