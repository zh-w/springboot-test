package com.wz.test.SpringbootTest.mybatis;

import com.wz.test.SpringbootTest.TestBase;
import com.wz.test.SpringbootTest.mybatis.entity.MetricKey;
import com.wz.test.SpringbootTest.mybatis.mapper.MetricKeyMapper;
import com.wz.test.SpringbootTest.mybatis.mapper.TestMapper;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MybatisCase extends TestBase {

    @Autowired
    private MetricKeyMapper metricKeyMapper;

    @Autowired
    private MybatisDemo mybatisDemo;

    //@Test
    public void queryTest(){
        List<MetricKey> list =  metricKeyMapper.getMetricKeyByKey("1.1.1.1","sys.use");
        System.out.println(list.size());
        System.out.println(list.get(0).toString());
        MetricKey metricKey = new MetricKey();
        metricKey.setHost("1.1.1.2");
        metricKey.setMetricKey("sys.all");
        int count = metricKeyMapper.insertMetricKey(metricKey);
        System.out.println(count);
        System.out.println(metricKey.getId());
    }

    //@Test
    public void accountTest(){
        ExecutorService threadPool = Executors.newFixedThreadPool(20);
        for (int i=0;i<10;i++){
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("transfer running...");
                    mybatisDemo.transfer(1,2,100);
                    System.out.println("transfer running after...");
                }
            });
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    mybatisDemo.transfer(1, 2, 100);
//                }catch(Exception e){
//                    System.out.println(e);
//                }
//            }
//        });
//
//        t.start();
//
//        try {
//            t.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        mybatisDemo.transfer(1,2,100);
        System.out.println("accountTest finished");
    }
}
