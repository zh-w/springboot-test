package com.wz.test.SpringbootTest.schdule;

import java.util.Date;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Auther: wangzheng
 * @Date: 2019-05-31 14:19
 * @Description:
 */
@Component
@EnableScheduling
public class Schedule {



    //@Scheduled(fixedRate = 5*1000)
    void work(){

        System.out.println("current time:"+new Date());
    }


}
