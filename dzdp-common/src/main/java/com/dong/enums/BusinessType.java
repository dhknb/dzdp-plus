package com.dong.enums;

import lombok.Getter;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: 业务类型
 * @author Dong
 **/
public enum BusinessType {
    /**
     * 业务类型
     * */
    SUCCESS(1, "创建订单成功"),
    TIMEOUT(2, "创建订单超时"),
    FAIL(3, "创建订单失败"),
    CANCEL(4, "主动取消"),
   
    
    ;
    
    @Getter
    private final Integer code;
    
    private String msg = "";
    
    BusinessType(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    
    public String getMsg() {
        return this.msg == null ? "" : this.msg;
    }
    
    public static String getMsg(Integer code) {
        for (BusinessType re : BusinessType.values()) {
            if (re.code.intValue() == code.intValue()) {
                return re.msg;
            }
        }
        return "";
    }
    
    public static BusinessType getRc(Integer code) {
        for (BusinessType re : BusinessType.values()) {
            if (re.code.intValue() == code.intValue()) {
                return re;
            }
        }
        return null;
    }
}
