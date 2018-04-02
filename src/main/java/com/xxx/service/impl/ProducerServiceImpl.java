package com.xxx.service.impl;

import com.xxx.config.KafkaConfig;
import com.xxx.service.ProducerService;
import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author User
 * @date 2018-04-02 15:17
 * @desc 生产者服务
 */
@Service
public class ProducerServiceImpl implements ProducerService {

    @Autowired
    private KafkaConfig config;

    @Value("${kafka.config.topic}")
    private String topic;

    @Override
    public void produceThd() {
        //创建kafka连接
        Producer producer = new Producer(config.createProduceerConfig());

        int messageNo = 0;
        final int COUNT = 5000;

        while (messageNo <= COUNT) {
            String key = String.valueOf(messageNo);
            String data = "hello kafka！"+  "第" + key +"message" ;
            producer.send(new KeyedMessage<String, String>(topic, key, data));
            //休眠1s
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("生产："+key + ","+data);

            messageNo++;
        }
        producer.close();

    }
}
