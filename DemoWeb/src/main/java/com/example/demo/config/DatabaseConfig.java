package com.example.demo.config;

import com.zaxxer.hikari.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

	@Value("${spring.datasource.url}")
	private String dbUrl;

	@Bean
	public DataSource dataSource() {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(dbUrl);
		config.setUsername("phqacqpsvttknm");
		config.setPassword("3a9824597bf125f5c3f1c835b39bfcfd417782f91d87fd8492d02767291058a5");
		config.setMaximumPoolSize(10);
		return new HikariDataSource(config);
	}
		
}