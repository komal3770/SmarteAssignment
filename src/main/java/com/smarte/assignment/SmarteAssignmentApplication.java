package com.smarte.assignment;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SmarteAssignmentApplication{

	private static Logger logger = LoggerFactory.getLogger(SmarteAssignmentApplication.class);
	
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SmarteAssignmentApplication.class, args);
		
		
	}

}
