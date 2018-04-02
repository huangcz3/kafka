package com.xxx.thread;

import com.xxx.service.InsertService;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.message.MessageAndMetadata;
import org.apache.log4j.Logger;

import java.io.UnsupportedEncodingException;

/**
 * @author User
 * @date 2018-04-02 11:42
 * @desc 消费线程类
 */
public class ConsumerThread implements Runnable {
    private KafkaStream<byte[], byte[]> stream;
    private InsertService insertService;
    private String path;
    private Logger logger = Logger.getLogger(ConsumerThread.class);

    //线程构造
    public ConsumerThread(KafkaStream stream, InsertService insertService, String path) {
        this.stream = stream;
        this.insertService = insertService;
        this.path = path;
    }


    @Override
    public void run() {
        logger.info("=========准备消费=========" + Thread.currentThread().getId());
        ConsumerIterator<byte[], byte[]> iterator = stream.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            try {
                MessageAndMetadata<byte[], byte[]> messageAndMetadata = iterator.next();
                String message = new String(messageAndMetadata.message(), "utf-8");
                logger.info("message:" + message);
                logger.info(++count + "=========" + Thread.currentThread().getId());
//                System.out.println("topic:" + messageAndMetadata.topic() + " " +
//                        "partition:" + messageAndMetadata.partition() + " " +
//                        "offset:" + messageAndMetadata.offset() + " " +
//                        "message:" + message);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

        }
    }
}
