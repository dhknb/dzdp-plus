package com.dong.redis;


import com.dong.core.RedisKeyManage;
import com.dong.core.SpringUtil;
import lombok.Getter;

import java.util.Objects;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: redis key包装
 * @author Dong
 **/
@Getter
public final class RedisKeyBuild {
    /**
     * 实际使用的key
     * */
    private final String relKey;

    private RedisKeyBuild(String relKey) {
        this.relKey = relKey;
    }

    /**
     * 构建真实的key
     * @param redisKeyManage key的枚举
     * @param args 占位符的值
     * */
    public static RedisKeyBuild createRedisKey(RedisKeyManage redisKeyManage, Object... args){
        String redisRelKey = String.format(redisKeyManage.getKey(),args);
        return new RedisKeyBuild(SpringUtil.getPrefixDistinctionName() + "-" + redisRelKey);
    }
    
    public static String getRedisKey(RedisKeyManage redisKeyManage) {
        return SpringUtil.getPrefixDistinctionName() + "-" + redisKeyManage.getKey();
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RedisKeyBuild that = (RedisKeyBuild) o;
        return relKey.equals(that.relKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(relKey);
    }
}
