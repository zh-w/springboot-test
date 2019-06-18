package com.wz.test.SpringbootTest.kafka;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.springframework.stereotype.Component;

/**
 * @Auther: wangzheng
 * @Date: 2019-06-17 10:02
 * @Description:
 */
@Component
public class MyPartitioner implements Partitioner {

    private static final String TOPIC = "muti-partition-test";

    private static Map<String,Integer> keys = new ConcurrentHashMap<>();

    private static Map<Integer, AtomicInteger> partitions = new ConcurrentHashMap<>();

    private static AtomicInteger test = new AtomicInteger(0);
    /**
     *
     * 根据ip做负载均衡，同一个ip每次需要发送到同一个partition
     * */
    @Override
    public int partition(String s, Object key, byte[] bytes, Object value, byte[] bytes1,
            Cluster cluster) {

       // System.out.println("partition.....");

        int partitionNum = cluster.partitionCountForTopic(TOPIC);

        if (partitions.size()!=partitionNum){
            synchronized (MyPartitioner.class){
                if (partitions.size()<partitionNum){
                    for (int i=partitions.size();i<partitionNum;i++){
                        partitions.put(i,new AtomicInteger(0));
                    }
                }

                if (partitions.size()>partitionNum){
                    rebalance();
                }
            }
        }
        String keyStr = (String)key;
        Integer partition = keys.get(key);

        if (partition==null){
            synchronized (keyStr.intern()){
                if ((partition=keys.get(key))==null){
                    System.out.println("partition==null :"+test.getAndIncrement());
                    List<Entry<Integer, AtomicInteger>> list = new ArrayList<>(partitions.entrySet());
                    //升序排序
                    Collections.sort(list, Comparator.comparingInt(o -> o.getValue().intValue()));
                    Entry<Integer,AtomicInteger> entry = list.get(0);
                    partition = entry.getKey();
                    entry.getValue().getAndIncrement();
                    keys.put(keyStr,partition);
                }
            }
        }
        //System.out.println("key:"+key+", partition:"+partition);

        return partition;
    }

    private void rebalance() {
        //todo
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> map) {

    }

}
