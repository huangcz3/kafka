package com.xxx.task;

import com.xxx.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author User
 * @date 2018-04-02 11:45
 * @desc
 */
@Component
@Order(value = 2)
public class ConsumerTask implements CommandLineRunner {

    @Autowired
    private ConsumerService consumerService;

    @Override
    public void run(String... strings) throws Exception {
        consumerService.ConsumerThd();
    }
}
