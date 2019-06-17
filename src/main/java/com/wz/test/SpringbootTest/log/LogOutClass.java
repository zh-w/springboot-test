package com.wz.test.SpringbootTest.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogOutClass {
    private final Logger logger = LoggerFactory.getLogger(LogOutClass.class);

    @RequestMapping("/log")
    public String logging(){
        System.out.println("start logging");
        for (int i=0;i<100;i++){
            logger.debug("debug"+i);
            logger.info("info"+i);
            logger.warn("warn"+i);
            logger.error("error"+i);
        }
        System.out.println("------end----");
        return "logging";
    }
}
