package com.zx.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhangyuxuan
 * @Date 2021年07月06日
 */
@SpringBootApplication
public class SpringBootZxApplication  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootZxApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}
}
