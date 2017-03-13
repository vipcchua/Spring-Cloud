package com.cchuaspace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cchuaspace.service.ComputeClient;

public class HtmlStart {

	
	 @Autowired
	    ComputeClient computeClient;
	
    @RequestMapping(value = "/" )
    public String Seldsada() {
        return computeClient.Seldsada();
    }
    
    @RequestMapping(value = "/login" )
    public String login() {
        return computeClient.login();
    }
	
}
