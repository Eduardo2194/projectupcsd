package com.upc.sistemasdistribuidos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//import com.upc.sistemasdistribuidos.service.UserService;

//@Configuration
//@EnableWebSecurity
public class SecurityConfig //extends WebSecurityConfigurerAdapter 
{

//	@Autowired
//	private UserService service;
	
	
//	@Autowired
//	private BCryptPasswordEncoder encoder;
	
//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//		return bCryptPasswordEncoder;
//		
//	}
	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) 
//			throws Exception{
		
//		auth.inMemoryAuthentication()
//			.withUser("user")
//			.password("123")
//			.roles("USER")
//			.and()
//			.withUser("admin")
//			.password("admin")
//			.roles("USER","ADMIN");

//		auth.userDetailsService(service).passwordEncoder(encoder);
//		
//	}
	
	
//	@Override
//	protected void configure(HttpSecurity http) 
//			throws Exception{
//		
//		http.authorizeRequests()
//			.anyRequest()
//			.authenticated()
//			.and()
//			.httpBasic();
//
//	}
//	
	
	
}
