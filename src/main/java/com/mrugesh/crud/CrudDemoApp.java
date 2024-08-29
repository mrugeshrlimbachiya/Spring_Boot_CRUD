package com.mrugesh.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class for the Spring Boot CRUD application.
 * <p>This is the entry point for the application and contains the {@code main} method
 * that triggers the Spring Boot framework to start the application context.</p>
 *
 * @author Mrugesh Limbachiya
 * @version openjdk-22
 */
@SpringBootApplication
public class CrudDemoApp {

	/**
	 * The main method that serves as the entry point of the application.
	 * <p>This method uses {@link SpringApplication#run(Class, String...)} to launch the application.</p>
	 *
	 * @param args Application startup arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApp.class, args);
	}

}
