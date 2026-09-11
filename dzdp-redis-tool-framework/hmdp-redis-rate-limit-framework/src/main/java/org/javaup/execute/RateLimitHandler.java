package com.dong.execute;
import com.dong.ratelimit.extension.RateLimitScene;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: 限流执行 接口
 * @author Dong
 **/
public interface RateLimitHandler {
   
    void execute(Long voucherId, Long userId, RateLimitScene scene);
}
