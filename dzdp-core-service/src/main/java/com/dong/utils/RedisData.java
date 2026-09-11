package com.dong.utils;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: redis数据
 * @author Dong
 **/
@Data
public class RedisData {
    private LocalDateTime expireTime;
    private Object data;
}
