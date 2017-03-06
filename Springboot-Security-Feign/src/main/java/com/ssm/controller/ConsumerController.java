package com.ssm.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssm.service.ComputeClient;


@RestController
public class ConsumerController {

    @Autowired
    ComputeClient computeClient;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer add() {
        return computeClient.add(10, 20);
    }
    

    @RequestMapping(value = "/mm", method = RequestMethod.GET)
    public Integer mm() {
        return computeClient.add(10, 20);
    }
    
    
    

}