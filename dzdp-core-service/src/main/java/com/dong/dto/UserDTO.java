package com.dong.dto;

import lombok.Data;
/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: 用户-入参
 * @author Dong
 **/
@Data
public class UserDTO {
    private Long id;
    private String nickName;
    private String icon;
}
