package com.dong.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dong.dto.LoginFormDTO;
import com.dong.dto.Result;
import com.dong.entity.User;
import jakarta.servlet.http.HttpSession;


/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: 用户 接口
 * @author Dong
 **/
public interface IUserService extends IService<User> {

    Result<String> sendCode(String phone, HttpSession session);

    Result<String> login(LoginFormDTO loginForm, HttpSession session);

    Result<Void> sign();

    Result<Integer> signCount();

}
