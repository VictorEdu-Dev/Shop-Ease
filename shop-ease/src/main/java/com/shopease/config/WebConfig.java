package com.shopease.config;


import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.shopease.controller.websocket.Endpoint;
import com.shopease.interceptor.logging.LoggingInterceptor;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@EnableWebSocket
@ComponentScan(basePackages = "com.shopease.controller, com.shopease.persistence.repository")
public class WebConfig implements WebMvcConfigurer, WebSocketConfigurer {
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("forward:/index");
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoggingInterceptor());
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("/content/assets/**")
	    .addResourceLocations("/content/assets/");
	}

	@Bean
	@Primary
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://sql10.freesqldatabase.com/sql10703105");
		dataSource.setUsername("sql10703105");
		dataSource.setPassword("L2QBgDa7fn");
		return dataSource;
	}
	
//	@Bean
//	public DataSource mysqlDataSource() {
//	    return dataSource();
//	}
	
	@Bean
	public ViewResolver internalViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/view/");
		resolver.setSuffix(".jsp");
		resolver.setOrder(1);
		resolver.setViewClass(JstlView.class);
		
		return resolver;
	}
	
	@Bean
	public ViewResolver externalViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/");
		resolver.setSuffix(".jsp");
		resolver.setOrder(2);
		resolver.setViewClass(JstlView.class);
		
		return resolver;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan("com.shopease.persistence");
		em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		em.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		em.setJpaProperties(additionalProperties());
		return em;
	}

	private Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.format_sql", "true");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		return properties;
	}
	
	@Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new Endpoint(), "/chat").setAllowedOrigins("*");
    }
}
