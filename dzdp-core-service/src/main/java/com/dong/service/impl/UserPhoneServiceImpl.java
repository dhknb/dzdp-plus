package com.dong.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import com.dong.entity.UserPhone;
import com.dong.mapper.UserPhoneMapper;
import com.dong.service.IUserPhoneService;
import org.springframework.stereotype.Service;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: 用户手机 接口实现
 * @author Dong
 **/
@Slf4j
@Service
public class UserPhoneServiceImpl extends ServiceImpl<UserPhoneMapper, UserPhone> implements IUserPhoneService {
    
}
