package com.webflux.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		System.setProperty("os.arch", "x86_64");
		SpringApplication.run(DemoApplication.class, args);
	}

}
