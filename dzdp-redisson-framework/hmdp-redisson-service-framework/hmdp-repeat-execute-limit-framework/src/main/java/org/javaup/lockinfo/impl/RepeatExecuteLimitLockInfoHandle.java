package com.dong.lockinfo.impl;

import com.dong.lockinfo.AbstractLockInfoHandle;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: 锁信息
 * @author Dong
 **/
public class RepeatExecuteLimitLockInfoHandle extends AbstractLockInfoHandle {

    public static final String PREFIX_NAME = "REPEAT_EXECUTE_LIMIT";
    
    @Override
    protected String getLockPrefixName() {
        return PREFIX_NAME;
    }
}
