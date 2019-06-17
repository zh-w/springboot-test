package com.wz.test.SpringbootTest.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Auther: wangzheng
 * @Date: 2019-06-17 09:46
 * @Description:
 */
@Component
public class KafkaProducer {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    private static final String TOPIC = "muti-partition-test";

    private int num = 0;

    //@Scheduled(fixedRate = 15*1000)
    public void send(){

        String message = "message"+num;

        String key = ""+num;

        kafkaTemplate.send(TOPIC, key, message);
        num++;
    }

}
