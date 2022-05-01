package com.me.advert;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.me.advert.controller", "com.me.advert.dao", "com.me.advert.pojo"})
public class InstaPizzaAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(InstaPizzaAppApplication.class, args);
	}

}
