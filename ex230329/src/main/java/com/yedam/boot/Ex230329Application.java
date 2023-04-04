package com.yedam.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages="com.yedam.boot.**.mapper")
public class Ex230329Application {

	public static void main(String[] args) {
		SpringApplication.run(Ex230329Application.class, args);
	}

}
