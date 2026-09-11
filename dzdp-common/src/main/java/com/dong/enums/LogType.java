package com.dong.enums;

import lombok.Getter;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: 记录类型
 * @author Dong
 **/
public enum LogType {
    /**
     * 记录类型
     * */
    DEDUCT(-1, "扣减"),
    
    RESTORE(1, "恢复"),
    ;
    
    @Getter
    private final Integer code;
    
    private String msg = "";
    
    LogType(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    
    public String getMsg() {
        return this.msg == null ? "" : this.msg;
    }
    
    public static String getMsg(Integer code) {
        for (LogType re : LogType.values()) {
            if (re.code.intValue() == code.intValue()) {
                return re.msg;
            }
        }
        return "";
    }
    
    public static LogType getRc(Integer code) {
        for (LogType re : LogType.values()) {
            if (re.code.intValue() == code.intValue()) {
                return re;
            }
        }
        return null;
    }
}
