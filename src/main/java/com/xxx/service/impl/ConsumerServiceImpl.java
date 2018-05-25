package com.xxx.service.impl;

import com.xxx.config.KafkaConfig;
import com.xxx.service.ConsumerService;
import com.xxx.thread.ConsumerThread;
import kafka.consumer.Consumer;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author User
 * @date 2018-04-02 11:36
 * @desc 消费者服务
 */
@Service
public class ConsumerServiceImpl implements ConsumerService {

    private Logger logger = LoggerFactory.getLogger(ConsumerService.class);

    @Autowired
    private InsertServiceImpl insertService;

    @Autowired
    private KafkaConfig config;

    @Value("${kafka.config.topic}")
    private String topic;

    @Value("${kafka.config.threadnum}")
    private int threadnum;

    @Value("${err.file.path}")
    private String errPath;

    @Override
    public void ConsumerThd() {
        //首先进行集群验证，该demo不需要验证
        //创建kafka连接
        ConsumerConnector consumer = Consumer.createJavaConsumerConnector(config.createConsumerConfig());
        Map<String, Integer> topicCountMap = new HashMap<>();
        topicCountMap.put(topic, threadnum);

        Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumer.createMessageStreams(topicCountMap);
        List<KafkaStream<byte[], byte[]>> streams = consumerMap.get(topic);

        //启动消费线程
        for (KafkaStream<byte[], byte[]> stream : streams) {
            logger.info("=========启动消费线程=========");
            ConsumerThread chd = new ConsumerThread(stream, insertService, errPath);
            new Thread(chd).start();
        }

    }


}
