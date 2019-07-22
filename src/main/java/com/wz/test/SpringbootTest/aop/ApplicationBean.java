package com.wz.test.SpringbootTest.aop;

import org.springframework.stereotype.Component;

/**
 * @Auther: wangzheng
 * @Date: 2019-07-14 11:14
 * @Description:
 */
@Component
public class ApplicationBean {

    public void watchMove(){
        System.out.println("watchmove");
    }

    public int shopping(int money){
        System.out.println("shopping");
        return money-10;
    }

}
