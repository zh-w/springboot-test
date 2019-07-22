package com.wz.test.SpringbootTest.init;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Component
public class CommandLineRunnerCase implements CommandLineRunner {

    @Value("${value}")
    private static int a ;


    @Override
    public void run(String... args) throws Exception {
        //System.out.println("CommandLineRunnerCase running.....,a:"+a);

    }
}
