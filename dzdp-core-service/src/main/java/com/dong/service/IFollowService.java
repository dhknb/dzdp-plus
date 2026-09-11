package com.dong.service;

import com.dong.dto.Result;
import com.dong.entity.Follow;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: 关注接口
 * @author Dong
 **/
public interface IFollowService extends IService<Follow> {

    Result follow(Long followUserId, Boolean isFollow);

    Result isFollow(Long followUserId);

    Result followCommons(Long id);
}
