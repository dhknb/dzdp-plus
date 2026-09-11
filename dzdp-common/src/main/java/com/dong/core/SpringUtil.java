package com.dong.core;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

import static com.dong.constant.Constant.DEFAULT_PREFIX_DISTINCTION_NAME;
import static com.dong.constant.Constant.PREFIX_DISTINCTION_NAME;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: spring工具
 * @author Dong
 **/
public class SpringUtil implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    
    private static ConfigurableApplicationContext configurableApplicationContext;
    
    
    public static String getPrefixDistinctionName(){
        return configurableApplicationContext.getEnvironment().getProperty(PREFIX_DISTINCTION_NAME,
                DEFAULT_PREFIX_DISTINCTION_NAME);
    }
    
    @Override
    public void initialize(final ConfigurableApplicationContext applicationContext) {
        configurableApplicationContext = applicationContext;
    }
}
