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
		config.setUsername("cwyonmgrvzdxkp");
		config.setPassword("b2d27d1f222068924c9d1106a55ca127692b31cbe1e17aacce94de8e48d8ef40");
		config.setMaximumPoolSize(10);
		return new HikariDataSource(config);
	}
		
}