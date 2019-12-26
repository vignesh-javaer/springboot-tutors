package com.personal.fervour;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableScheduling
@ComponentScan(basePackages = "com.personal")
public class FervourPersonalAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FervourPersonalAppApplication.class, args);
	}

}
