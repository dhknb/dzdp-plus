package com.dong.servicelock.info;


/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: 策略
 * @author Dong
 **/
public enum LockTimeOutStrategy implements LockTimeOutHandler{
    /**
     * 快速失败
     * */
    FAIL(){
        @Override
        public void handler(String lockName) {
            String msg = String.format("%s请求频繁",lockName);
            throw new RuntimeException(msg);
        }
    }
}
