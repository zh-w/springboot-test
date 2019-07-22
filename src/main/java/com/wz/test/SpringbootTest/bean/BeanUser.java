package com.wz.test.SpringbootTest.bean;

import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @Auther: wangzheng
 * @Date: 2019-07-02 13:51
 * @Description:
 */
@Component
public class BeanUser {

    @Autowired
    //@Qualifier("aaddasff")
    private SimpleBean simpleBean;

//    @Autowired
//    public void setSimpleBean(SimpleBean simpleBean) {
//        this.simpleBean = simpleBean;
//    }

    public BeanUser(SimpleBean simpleBean) {
        this.simpleBean = simpleBean;
    }

    public void init(){
        System.out.println("BeanUser init ,"+"simpleBean.age:"+simpleBean.getAge());
    }

}
