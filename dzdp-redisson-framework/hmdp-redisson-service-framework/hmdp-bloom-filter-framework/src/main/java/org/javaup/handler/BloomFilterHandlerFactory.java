package com.dong.handler;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: 根据名称获取 BloomFilterHandler 的工厂。
 * @author Dong
 **/
public class BloomFilterHandlerFactory implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public BloomFilterHandler get(String name){
        return applicationContext.getBean(name, BloomFilterHandler.class);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}