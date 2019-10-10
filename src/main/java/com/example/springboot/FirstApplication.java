package com.example.springboot;

import com.example.springboot.model.Person;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FirstApplication implements CommandLineRunner {

	public static void main(String[] args) {
//		SpringApplication.run(FirstApplication.class, args);
		ConfigurableApplicationContext context = SpringApplication.run(FirstApplication.class, args);
		Person person = context.getBean(Person.class);
		person.sayHello();
		System.out.println(person.getClass());
	}

	@Override
	public void run(String... args) throws Exception {

	}


}
