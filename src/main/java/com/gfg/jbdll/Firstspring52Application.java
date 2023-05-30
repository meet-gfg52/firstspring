package com.gfg.jbdll;

import com.gfg.jbdll.domain.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.util.Arrays;
import java.util.Objects;

@SpringBootApplication
public class Firstspring52Application implements CommandLineRunner{

	public static void main(String[] args) {

		SpringApplication.run(Firstspring52Application.class, args);
	}

	@Autowired
	ApplicationContext context;

	@Value("${counter}")
	Integer count; // -> lowest one is initialized one

	@Override
	public void run(String... args) throws Exception {
		System.out.println(count);
	}

	/***
	 * Run time application properties
	 *
	 * Scenario 1
	 * java -jar first....jar
	 *
	 * output:
	 * 	counter=10
	 *
	 *
	 * Scenario 2
	 * java -jar first....jar application.properties(counter = 50)
	 *
	 * output:
	 * 	 * 	counter=50
	 *
	 *
	 * Scenario 3
	 * java -jar first....jar application.properties(spring.profiles.active=dev counter=50)
	 *
	 * output:
	 * 	 * 	 * 	counter=20
	 *
	 *
	 * Scenario 4
	 *
	 * java -jar first....jar application.properties(spring.profiles.active=dev counter=50) application-dev.properties(counter=100)
	 * 	 *
	 * 	 * output:
	 * 	 * 	 * 	 * 	counter=20
	 *
	 *
	 * 	 Scenario 4
	 * 	 *
	 * 	 * java -jar first....jar counter=100 dbtype=postgres
	 * 	 * 	 *
	 * 	 * 	 * output:
	 * 	 * 	 * 	 * 	 * 	counter=100
	 *
	 *
	 *
	 * */
}























