package com.bader88.springaopdemo;

import com.bader88.springaopdemo.aop.business.BusinessService1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringAopDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(getClass());

	private BusinessService1 businessService1;
	public SpringAopDemoApplication(BusinessService1 businessService1){
		this.businessService1 = businessService1;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringAopDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Value returned is{}",businessService1.calculateMax());
		;
	}
}
