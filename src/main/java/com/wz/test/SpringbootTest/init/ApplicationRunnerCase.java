package com.wz.test.SpringbootTest.init;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class ApplicationRunnerCase implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //Thread.sleep(10*1000);
        //System.out.println("ApplicationRunnerCase running.....");
        //BeanDefinition
    }
}
