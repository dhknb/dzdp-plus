package com.dong.ratelimit.extension;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: 限流场景
 * @author Dong
 **/
public enum RateLimitScene {
    /** 发令牌接口 */
    ISSUE_TOKEN,
    /** 下单（秒杀）接口 */
    SECKILL_ORDER
}