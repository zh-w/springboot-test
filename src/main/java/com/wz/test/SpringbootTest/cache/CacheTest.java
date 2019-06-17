package com.wz.test.SpringbootTest.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class CacheTest implements ApplicationRunner {

    @Autowired
    private CacheCase cacheCase;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("CacheTest running.....");
//        cacheCase.getItemById(1);
//        cacheCase.getItemById(1);
//        cacheCase.getItemById(1);
//        cacheCase.getItemById(2);
//        cacheCase.getItemById(2);


        cacheCase.setItemInfo(4);
        cacheCase.setItemInfo(4);
        cacheCase.setItemInfo(5);
        cacheCase.setItemInfo(6);
        cacheCase.deleteItemaInfo(5);

        System.out.println(cacheCase.getItemById(4));
        System.out.println(cacheCase.getItemById(5));
        System.out.println(cacheCase.getItemById(6));


    }
}
