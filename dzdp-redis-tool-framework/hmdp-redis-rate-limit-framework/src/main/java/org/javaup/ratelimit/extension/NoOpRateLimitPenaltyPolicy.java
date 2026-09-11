package com.dong.ratelimit.extension;

import com.dong.enums.BaseCode;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: 默认空实现
 * @author Dong
 **/
public class NoOpRateLimitPenaltyPolicy implements RateLimitPenaltyPolicy {
    @Override
    public void apply(RateLimitContext ctx, BaseCode reason) {
        // no-op
    }
}