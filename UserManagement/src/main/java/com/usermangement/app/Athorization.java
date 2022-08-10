package com.usermangement.app;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
@Configuration
@EnableWebSecurity
public class Athorization extends WebSecurityConfigurerAdapter
{

	 @Override
	    public void configure(HttpSecurity http) throws Exception {
	       http.csrf().disable().authorizeRequests()
	        .antMatchers("/").permitAll()
	        .antMatchers("/createuser").permitAll()
	        .antMatchers("/updatepassword").permitAll()
	        .antMatchers("/login/**").permitAll()
	        .antMatchers(HttpMethod.GET,"/home").permitAll()
 	        .anyRequest().authenticated();
    
	 
	 }
}
