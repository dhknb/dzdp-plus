package com.dong;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: 服务启动-大众点评普通版本和plus版本使用
 * @author Dong
 **/
@EnableAspectJAutoProxy(exposeProxy = true)
@MapperScan("com.dong.mapper")
@SpringBootApplication
public class HmDianPingApplication {

    public static void main(String[] args) {
        SpringApplication.run(HmDianPingApplication.class, args);
    }

}
