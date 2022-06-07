package com.nightfury.farmersmarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@SpringBootApplication
public class FarmersMarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(FarmersMarketApplication.class, args);
	}

}
