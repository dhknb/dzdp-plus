package com.dong.servicelock.factory;

import com.dong.core.ManageLocker;
import com.dong.servicelock.LockType;
import com.dong.servicelock.ServiceLocker;
import lombok.AllArgsConstructor;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: 工厂
 * @author Dong
 **/
@AllArgsConstructor
public class ServiceLockFactory {
    
    private final ManageLocker manageLocker;
    

    public ServiceLocker getLock(LockType lockType){
        ServiceLocker lock;
        switch (lockType) {
            case Fair:
                lock = manageLocker.getFairLocker();
                break;
            case Write:
                lock = manageLocker.getWriteLocker();
                break;
            case Read:
                lock = manageLocker.getReadLocker();
                break;
            default:
                lock = manageLocker.getReentrantLocker();
                break;
        }
        return lock;
    }
}
