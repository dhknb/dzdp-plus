package com.dong.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dong.dto.Result;
import com.dong.entity.UserInfo;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: 用户信息 接口
 * @author Dong
 **/
public interface IUserInfoService extends IService<UserInfo> {
    
    /**
     * 通过用户id查询用户信息
     * @param userId 用户ID
     * @return 结果
     */
    UserInfo getByUserId(Long userId);
    
    /**
     * 更新用户等级，并维护等级倒排索引集合
     * @param userId 用户ID
     * @param newLevel 新等级
     * @return 结果
     */
    Result<Void> updateUserLevel(Long userId, Integer newLevel);

}
