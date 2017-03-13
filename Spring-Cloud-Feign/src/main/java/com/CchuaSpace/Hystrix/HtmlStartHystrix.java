package com.cchuaspace.hystrix;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import com.cchuaspace.service.HtmlStartClient;



@Component
public class HtmlStartHystrix implements HtmlStartClient {

	@Override
	public String indexstart() {

		return "INDEX ERROR";
	}

 
}