package com.wz.test.SpringbootTest.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

/**
 * @Auther: wangzheng
 * @Date: 2019-06-29 21:29
 * @Description:
 */
@Configuration
public class BeanCase {

    @Bean(value = {"simpleB1", "simpleB3"},initMethod = "init", destroyMethod = "destory")
    @Primary
    public SimpleBean simpleBean(){
        SimpleBean simpleBean = new SimpleBean();
        simpleBean.name="mybean1";
        return simpleBean;
    }

    @Bean(name = "simpleB2",initMethod = "init", destroyMethod = "destory")
    @Scope("prototype")
    public SimpleBean simpleBean1(){
        SimpleBean simpleBean = new SimpleBean();
        simpleBean.name="mybean2";
        return simpleBean;
    }

    @Bean("dataSourceProd")
    @Profile("prod")
    public DataSourceBean dataSourceBean(){
        DataSourceBean dataSourceBean = new DataSourceBean();
        dataSourceBean.setEnv("prod");
        return dataSourceBean;
    }

    @Bean("dataSourceDev")
    @Profile("dev")
    public DataSourceBean dataSourceBean1(){
        DataSourceBean dataSourceBean = new DataSourceBean();
        dataSourceBean.setEnv("dev");
        return dataSourceBean;
    }
}
