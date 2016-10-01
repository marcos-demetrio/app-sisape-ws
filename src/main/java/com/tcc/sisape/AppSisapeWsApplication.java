package com.tcc.sisape;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppSisapeWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppSisapeWsApplication.class, args);

		TimeZone.setDefault(TimeZone.getTimeZone("GMT-0200"));
	}
}
