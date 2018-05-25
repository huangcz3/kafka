package com.xxx.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisCluster;

import java.util.Set;

/**
 * @author Huangcz
 * @date 2018-05-23 10-40
 * @desc
 */
@Component
public class RedisTest {

    private static final Logger logger = LoggerFactory.getLogger(RedisTest.class);

    @Autowired
    private JedisCluster jedisCluster;

//    @Scheduled(cron = "0/5 * *  * * ? ")
    public void test(){
        Set set = jedisCluster.smembers("test");

        set.forEach(s ->{
            logger.info((String) s);
        });

        System.out.println(set);
    }


}
