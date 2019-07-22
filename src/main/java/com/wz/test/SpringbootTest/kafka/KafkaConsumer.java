package com.wz.test.SpringbootTest.kafka;

import java.util.Random;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

/**
 * @Auther: wangzheng
 * @Date: 2019-06-17 09:52
 * @Description:
 */
@Component
public class KafkaConsumer {

    private static final String TOPIC = "muti-partition-test";
    private static final String TOPIC1 = "muti-replication-test";

    static final String s = " "+new Random().nextInt();

    //@KafkaListener(topics = TOPIC , groupId = "${kafka.test.group}")
    //@KafkaListener(topics = TOPIC1 )
    public void consume(ConsumerRecord record){

        String message = record.value().toString();

        System.out.println("offset:"+record.offset());
        System.out.println("group :wz.group1 message:"+message);

    }

}
