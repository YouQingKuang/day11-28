package com.example.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaijCongfiguration {

	@Bean
	public FooProperties getFoo() {
		return new FooProperties();
	}
	
}
