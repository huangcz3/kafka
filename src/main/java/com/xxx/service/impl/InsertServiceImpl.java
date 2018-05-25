package com.xxx.service.impl;

import com.xxx.mapper.TestMapper;
import com.xxx.service.InsertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

/**
 * @author User
 * @date 2018-04-02 11:37
 * @desc
 */
@Service
public class InsertServiceImpl implements InsertService {

    @Autowired
    private TestMapper testMapper;

    @Autowired
    private JedisCluster jedisCluster;

    @Override
    public void insert(String message) {
        jedisCluster.sadd("test",message);
//        testMapper.insert(message);
    }
}
