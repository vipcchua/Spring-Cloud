package com.cchuaspace.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Configuration
public class SecurityConfig extends WebMvcConfigurerAdapter {

	@Bean
	public SecurityInterceptor getSecurityInterceptor() {
		return new SecurityInterceptor();
	}

	public void addInterceptors(InterceptorRegistry registry) {
		InterceptorRegistration addInterceptor = registry.addInterceptor(getSecurityInterceptor());

		// 多个拦截器组成一个拦截器链

		// 添加拦截规则:addPathPatterns

	/*
		addInterceptor.addPathPatterns("/**");
		// 排除拦截:excludePathPatterns
		addInterceptor.excludePathPatterns("/api/system/login");
		addInterceptor.excludePathPatterns("/api/system/getverifiCode");
		addInterceptor.excludePathPatterns("/api/wecaht/**");*/
		
		addInterceptor.excludePathPatterns("/**");
		
		super.addInterceptors(registry);
	}

	private class SecurityInterceptor extends HandlerInterceptorAdapter {

		@Override
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
				throws Exception {
			System.err.println("aaa");
			return false;
		}

	}

}
