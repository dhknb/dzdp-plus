package com.dong.utils;

import com.dong.dto.UserDTO;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: 用户持有器-大众点评普通版本和plus版本使用
 * @author Dong
 **/
public class UserHolder {
    private static final ThreadLocal<UserDTO> TL = new ThreadLocal<>();

    public static void saveUser(UserDTO user){
        TL.set(user);
    }

    public static UserDTO getUser(){
        return TL.get();
    }

    public static void removeUser(){
        TL.remove();
    }
}
