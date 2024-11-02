package com.java_test.javaSpringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class JavaSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaSpringbootApplication.class, args);
	}

}
