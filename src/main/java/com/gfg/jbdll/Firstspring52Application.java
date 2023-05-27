package com.gfg.jbdll;

import com.gfg.jbdll.domain.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.util.Arrays;
import java.util.Objects;

@SpringBootApplication
public class Firstspring52Application{

	public static void main(String[] args) {

		SpringApplication.run(Firstspring52Application.class, args);
	}

	@Autowired
	ApplicationContext context;




}























