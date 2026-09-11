package com.dong.dto;

import lombok.Data;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: 登录-入参
 * @author Dong
 **/
@Data
public class LoginFormDTO {
    private String phone;
    private String code;
    private String password;
}
