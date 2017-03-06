package com.CchuaSpace.Hystrix;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import com.CchuaSpace.Service.HtmlStartClient;



@Component
public class HtmlStartHystrix implements HtmlStartClient {

	@Override
	public String indexstart() {

		return "INDEX ERROR";
	}

 
}