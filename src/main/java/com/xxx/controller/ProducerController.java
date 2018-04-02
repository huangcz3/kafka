package com.xxx.controller;

import com.xxx.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author User
 * @date 2018-04-02 15:53
 * @desc
 */
@Controller
@RequestMapping
public class ProducerController {

    @Autowired
    private ProducerService producerService;

    @ResponseBody
    @RequestMapping(value = "/produce",method = RequestMethod.GET)
    public String produce(){
        producerService.produceThd();
        return "success";
    }

}
