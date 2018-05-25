package com.xxx.task;

import com.xxx.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author User
 * @date 2018-04-02 15:50
 * @desc 生产者task
 */
//@Component
//@Order(value = 1)
public class ProducerTask implements CommandLineRunner{

    @Autowired
    private ProducerService producerService;

    @Override
    public void run(String... args) throws Exception {
        producerService.produceThd();
    }
}
