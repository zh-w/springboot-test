package com.wz.test.SpringbootTest.kafka;

import java.util.Map;
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

    @Override
    public int partition(String s, Object o, byte[] bytes, Object o1, byte[] bytes1,
            Cluster cluster) {
        int partitionNum = cluster.partitionCountForTopic(TOPIC);
        String key = (String) o;
        int intKey = Integer.parseInt(key);
        String value = (String) o1;

        return intKey%partitionNum;
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}
