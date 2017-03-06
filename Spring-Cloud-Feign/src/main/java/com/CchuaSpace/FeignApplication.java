package com.CchuaSpace;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;



@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients

@MapperScan("com.CchuaSpace.Mapper")
@EnableConfigurationProperties({ CchuaProperties.class, CchuaProperties.class })

public class FeignApplication {

	private static Logger logger = Logger.getLogger(FeignApplication.class);
	
	@Autowired
	CchuaProperties CchuaProperties;
	
	

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		return new org.apache.tomcat.jdbc.pool.DataSource();
	}
	
	
	
	
	@Bean
	public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

		sqlSessionFactoryBean.setTypeAliases(new Class[] {
				
				/*	*  TableUser.class*/

		});
		sqlSessionFactoryBean.getObject().getConfiguration().setMapUnderscoreToCamelCase(
				true);/* 自动支持驼峰 table_Aaa -->--tableaaa */

		/*
		 * sqlSessionFactoryBean.setMapperLocations(resolver.getResources(
		 * "classpath:/mybatis/*.xml"));
		 */
		return sqlSessionFactoryBean.getObject();
	}
	
	
	
	
	
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
	
	
	
	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", buildConfig()); // 4
		return new CorsFilter(source);
	}


	@Configuration
	public class MvcConfiguration extends WebMvcConfigurerAdapter {

		@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
			registry.addResourceHandler("/ssmimg/**")
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
	

	public static void main(String[] args) {	logger.info("Author:Cchua\n");
	logger.info("GitHub:https://github.com/vipcchua\n");
	logger.info("Blog:weibo.com/vipcchua\n");
	/*后台版本号*/
	logger.info("Backstage Versions:3.5\n");
	logger.info("Backstage updateTime:2017年1月4日10:16:10\n");
	/*代码版信息 */
	logger.info("Code Versions:4.6.8\n");
	logger.info("EndUpdate:2017年1月10日15:14:27\n");
	
	logger.info("Welcome to use this System");
		SpringApplication.run(FeignApplication.class, args);
	}

}
