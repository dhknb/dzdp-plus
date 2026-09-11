package com.dong.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: 用户手机
 * @author Dong
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_user_phone")
public class UserPhone implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id")
    private Long id;
    
    /**
     * 用户id
     */
    private Long userId;

    /**
     * 手机号码
     */
    private String phone;
    
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    
    
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
