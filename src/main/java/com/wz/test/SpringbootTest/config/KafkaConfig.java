package com.wz.test.SpringbootTest.config;

import com.wz.test.SpringbootTest.kafka.MyPartitioner;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

/**
 * @Auther: wangzheng
 * @Date: 2019-06-17 09:38
 * @Description:
 */
@Configuration
public class KafkaConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String kafkaAddress;

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put("bootstrap.servers", kafkaAddress);
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("max.poll.records", 500);
        //配置当没有offset时 从头消费
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");
        props.put("key.deserializer", StringDeserializer.class);
        props.put("value.deserializer", StringDeserializer.class);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, UUID.randomUUID().toString());

        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(new DefaultKafkaConsumerFactory<String, String>(props));
        return factory;
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaAddress);
        //设置失败重试
        props.put(ProducerConfig.RETRIES_CONFIG, 1);
        //设置批量发送
        props.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
        //设置发送等待时间，若达到最大批量发送的数量，将直接发送而不用等待
        props.put(ProducerConfig.LINGER_MS_CONFIG, 1);
        //ack= 1发送后，leader保存消息之后立即回复，而不用等待fellowers备份完回复；ack=all，需等待所有fellower备份完再回复
        props.put(ProducerConfig.ACKS_CONFIG,"1");
        //生产者可用的最大内存容量
        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 1024000);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, MyPartitioner.class);
        ProducerFactory<String, String> factory = new DefaultKafkaProducerFactory<String, String>(props);
        KafkaTemplate<String, String> template = new KafkaTemplate<String, String>(factory);
        return template;
    }
}
