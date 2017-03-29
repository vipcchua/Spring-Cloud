package com.cchuaspace;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;

import javax.servlet.MultipartConfigElement;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import org.mybatis.spring.mapper.MapperScannerConfigurer;

import com.cchuaspace.model.OrderInfo;
import com.cchuaspace.model.TableUser;
@MapperScan({"com.cchuaspace.mapper"})
@EnableDiscoveryClient
@SpringBootApplication

@ServletComponentScan

@EnableAutoConfiguration
@ComponentScan
/* @ComponentScan(basePackages={"com.CchuaSpace.Pojo"}) */
@EnableConfigurationProperties({ CchuaProperties.class, CchuaProperties.class })
public class Application {
	private static Logger logger = Logger.getLogger(Application.class);

	@Autowired
	CchuaProperties CchuaProperties;

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		return new org.apache.tomcat.jdbc.pool.DataSource();
	}
	/* Spring Boot普通类调用bean */
	/*
	 * @Bean public SpringUtil springUtil(){ return new SpringUtil(); }
	 */

	@Bean
	public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

		
		
		sqlSessionFactoryBean.setTypeAliases(new Class[] { TableUser.class,OrderInfo.class

		});
		sqlSessionFactoryBean.getObject().getConfiguration().setMapUnderscoreToCamelCase(
				true);
		//自动支持驼峰 table_Aaa -->--tableaaa 

		
	 /* sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:com/cchuaspace/xml/mapper/*.xml"));*/
		
		 
		sqlSessionFactoryBean.getObject().getConfiguration().setAggressiveLazyLoading(true);
		
		sqlSessionFactoryBean.getObject().getConfiguration().setDefaultStatementTimeout(25000);
		  
		return sqlSessionFactoryBean.getObject();
	}
	
	/*@Bean 
	public MapperScannerConfigurer mapperin() {
		
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		  mapperScannerConfigurer.setBasePackage("com.cchuaspace.dao");
		return mapperScannerConfigurer;
		  
		
		
	}
	*/
	

	@Bean
	@ConditionalOnMissingBean({ RestOperations.class, RestTemplate.class })
	public RestOperations restOperations() {
		SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
		requestFactory.setReadTimeout(5000);
		requestFactory.setConnectTimeout(5000);

		RestTemplate restTemplate = new RestTemplate(requestFactory);

		// 使用 utf-8 编码集的 conver 替换默认的 conver（默认的 string conver 的编码集为
		// "ISO-8859-1"）
		List<HttpMessageConverter<?>> messageConverters = restTemplate.getMessageConverters();
		Iterator<HttpMessageConverter<?>> iterator = messageConverters.iterator();
		while (iterator.hasNext()) {
			HttpMessageConverter<?> converter = iterator.next();
			if (converter instanceof StringHttpMessageConverter) {
				iterator.remove();
			}
		}
		messageConverters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));

		return restTemplate;
	}

	/*
	 * 创建SqlSessionFactory的同时，将其配置项MapUnderscoreToCamelCase设置为true，如数据库列
	 * user_name将自动映射到pojo中的userName属性
	 * 
	 * 通过setTypeAliases，指定使用的Pojo类型，后续Mapper.xml中就不需要指定Pojo类型的完整限定名（
	 * 即无需指定namespace）
	 * 
	 */

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}

	private CorsConfiguration buildConfig() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.addAllowedOrigin("*"); // 1
		corsConfiguration.addAllowedHeader("*"); // 2
		corsConfiguration.addAllowedMethod("*"); // 3
		return corsConfiguration;
	}
	/* http://10.3.13.212:8080/ssmimg/a.jpg */

	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", buildConfig()); // 4
		return new CorsFilter(source);
	}

	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		factory.setMaxFileSize("10MB");
		factory.setMaxRequestSize("10MB");
		return factory.createMultipartConfig();
	}

	// @Configuration
	// public class MvcConfiguration extends WebMvcConfigurerAdapter {
	//
	// @Override
	// public void addResourceHandlers(ResourceHandlerRegistry registry) {
	// registry.addResourceHandler("/ssmimg/**").addResourceLocations("classpath:/ssmimg/");
	// super.addResourceHandlers(registry);
	// }
	//
	//
	// }

	@Configuration
	public class MvcConfiguration extends WebMvcConfigurerAdapter {

		@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
			registry.addResourceHandler("/data/**")
					.addResourceLocations("file:" + CchuaProperties.getUpfilePosition());
			super.addResourceHandlers(registry);
		}
	}


	
	
	
	
	@Configuration
	public class MyHtml extends WebMvcConfigurerAdapter {

		@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
			registry.addResourceHandler("/**").addResourceLocations("file:" + CchuaProperties.getHtmlPosition());
			super.addResourceHandlers(registry);
		}
	}

	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {
		return new EmbeddedServletContainerCustomizer() {
			@Override
			public void customize(ConfigurableEmbeddedServletContainer container) {
				container.setSessionTimeout(1800);// 单位为S
			}
		};
	}

	public static void main(String[] args) {
		new SpringApplicationBuilder(Application.class).web(true).run(args);

		logger.info("SpringBoot Start Success\n");
		logger.info("Author:Cchua\n");
		logger.info("GitHub:https://github.com/vipcchua\n");
		logger.info("Blog:weibo.com/vipcchua\n");
		/* 后台版本号 */
		logger.info("Backstage Versions:3.5\n");
		logger.info("Backstage updateTime:2017年1月4日10:16:10\n");
		/* 代码版信息 */
		logger.info("Code Versions:4.6.8\n");
		logger.info("EndUpdate:2017年1月10日15:14:27\n");

		logger.info("Welcome to use this System");
	}

}
