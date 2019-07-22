package com.wz.test.SpringbootTest.kafka;

import com.alibaba.fastjson.JSON;
import com.harmonycloud.aiops.common.entity.Item;
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
    private static final String TOPIC1 = "muti-replication-test";
    private static final String TOPIC2 = "null-test";

    private int num = 0;

    //@Scheduled(fixedRate = 5*1000)
    public void send(){

        for (int i=0;i<10;i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String message = "message" + num;
                    num++;

                    String key = "" + num % 50;
                    kafkaTemplate.send(TOPIC1, key, message);
                }
            }).start();
        }
    }

    //@Scheduled(fixedRate = 5*1000)
    public void send1(){

//        for (int i=0;i<10;i++){
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    String message = "message"+num;
//                    num++;
//
//                    String key = ""+num%50;
//                    kafkaTemplate.send(TOPIC1, key, message);
//                }
//            }).start();

        Item item = new Item();
        item.setItemId(5511L);
        item.setPlatform("zabbix");
        item.setRecordTime(1561449555L);
        item.setHost("Zabbix server");
        item.setStep(60);
        item.setTag("[percpu,avg1]");
        item.setMetric("system.cpu.load[percpu,avg1]");
        kafkaTemplate.send(TOPIC2,"5511", JSON.toJSON(item).toString());
        System.out.println(item.toString());
    }

}
