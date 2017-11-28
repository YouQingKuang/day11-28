package com.example.basic;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class BasicApplication {

	private static final Logger log = LoggerFactory.getLogger(BasicApplication.class);

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BasicApplication.class, args);

		System.out.println(context.getBean(Info.class));
		log.debug(context.getId());
		log.debug("Info => {}", context.getBean(Info.class));
		
		FooProperties fooProperties = (FooProperties) context.getBean("getFoo");
		System.out.println(fooProperties);
		
	}

	@Bean
	public HealthIndicator health() {
		return () -> {
			boolean errorCode = check(); 
			if(errorCode == false) {
			return Health.down().withDetail("Error",errorCode).build();
			}
			return Health.up().withDetail("Ok",errorCode).build();
		};
	}
	public boolean check() {
		//System.out.println(HttpStatus.NOT_FOUND.value());
		String host =  "www.baidu.com" ;       
		int  timeOut =  3000 ;
		boolean status = false;
		try {
			status = InetAddress.getByName(host).isReachable(timeOut);
			System.out.println(status);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return status;
	}

}
