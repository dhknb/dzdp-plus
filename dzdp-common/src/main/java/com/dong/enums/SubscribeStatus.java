package com.dong.enums;

import lombok.Getter;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: 是否删除秒杀优惠券订单记录
 * @author Dong
 **/
public enum SubscribeStatus {
    /**
     * 是否删除秒杀优惠券订单记录
     * */
    UNSUBSCRIBED(0, "已取消订阅或未订阅"),
    
    SUBSCRIBED(1, "已订阅到券提醒（在队列中）"),
    
    SUCCESS(2,"自动发券已成功（已创建订单）")
    ;
    
    @Getter
    private final Integer code;
    
    private String msg = "";
    
    SubscribeStatus(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    
    public String getMsg() {
        return this.msg == null ? "" : this.msg;
    }
    
    public static String getMsg(Integer code) {
        for (SubscribeStatus re : SubscribeStatus.values()) {
            if (re.code.intValue() == code.intValue()) {
                return re.msg;
            }
        }
        return "";
    }
    
    public static SubscribeStatus getRc(Integer code) {
        for (SubscribeStatus re : SubscribeStatus.values()) {
            if (re.code.intValue() == code.intValue()) {
                return re;
            }
        }
        return null;
    }
}
