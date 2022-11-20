package com.withstudy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = {"com.withstudy.mapper"})
@SpringBootApplication
public class WithStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(WithStudyApplication.class, args);
	}

}
