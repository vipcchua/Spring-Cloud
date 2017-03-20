package com.cchuaspace.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;



public class TimingTaskConfig {
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	
	@Scheduled(cron = "0 0/30 * * * ? ")
	public void orderTask() {


	/*	stringRedisTemplate..*/
		
	}
}
