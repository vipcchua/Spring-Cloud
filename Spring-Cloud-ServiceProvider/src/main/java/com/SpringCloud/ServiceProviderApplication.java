package com.SpringCloud;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ServiceProviderApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ServiceProviderApplication.class).web(true).run(args);
	}

}