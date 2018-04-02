package com.xxx.config;

import kafka.consumer.ConsumerConfig;
import kafka.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * @author User
 * @date 2018-04-02 11:38
 * @desc
 */
@Component
public class KafkaConfig {

    @Value("${kafka.config.zk}")
    private String zkServer;

    @Value("${kafka.config.broker}")
    private String broker;

    @Value("${kafka.config.groupid}")
    private String groupid;

    @Value("${kafka.config.topic}")
    private String topic;

    @Value("${kafka.config.threadnum}")
    private int threadnum;

    @Value("${err.file.path}")
    private String errPath;

    /**
     * kafka消费者连接属性
     *
     * @return
     */
    public ConsumerConfig createConsumerConfig() {
        Properties props = new Properties();
        props.put("zookeeper.connect", zkServer);
//        props.put("bootstrap.servers",broker);
        props.put("key.deserializer", "org.apache.kafka.common.serialization.Deserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.Deserializer");
        props.put("group.id", groupid);
        props.put("zookeeper.session.timeout.ms", "50000");
        props.put("zookeeper.sync.time.ms", "2000");
        //此处使用默认值从最新的开始取消息
//        props.put("auto.offset.reset", "latest");
        props.put("auto.commit.enable", "true");
        props.put("auto.commit.interval.ms", "10000");
        ConsumerConfig config = new ConsumerConfig(props);
        return config;
    }

    public ProducerConfig createProduceerConfig() {
        Properties props = new Properties();
        //此处配置的是kafka的端口
        props.put("metadata.broker.list", "192.168.201.50:9092");

        //配置value的序列化类
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        //配置key的序列化类
        props.put("key.serializer.class", "kafka.serializer.StringEncoder");
        /**
         * request.required.acks
         *  0, which means that the producer never waits for an acknowledgement from the broker (the same behavior as 0.7). This option provides the lowest latency but the weakest durability guarantees (some data will be lost when a server fails).
         *  1, which means that the producer gets an acknowledgement after the leader replica has received the data. This option provides better durability as the client waits until the server acknowledges the request as successful (only messages that were written to the now-dead leader but not yet replicated will be lost).
         * -1, which means that the producer gets an acknowledgement after all in-sync replicas have received the data. This option provides the best durability, we guarantee that no messages will be lost as long as at least one in sync replica remains.
         */
        props.put("request.required.acks", "-1");

        return new ProducerConfig(props);
    }

}
