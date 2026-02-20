package com.research.research_assistant;

// Import SpringApplication class
// This class is used to start and launch the Spring Boot application
import org.springframework.boot.SpringApplication;


// Import SpringBootApplication annotation
// This is the main annotation that enables Spring Boot features
import org.springframework.boot.autoconfigure.SpringBootApplication;



// @SpringBootApplication is the main annotation of Spring Boot
//
// It is a combination of three annotations:
//
// 1. @Configuration
//    → Marks this class as a configuration class
//    → Used to define Spring Beans
//
// 2. @EnableAutoConfiguration
//    → Automatically configures Spring Boot based on dependencies
//    → Example:
//         If Spring Web dependency is present,
//         Spring Boot automatically configures Tomcat server
//
// 3. @ComponentScan
//    → Scans current package and sub-packages
//    → Finds:
//
//         @Controller
//         @Service
//         @Repository
//         @Component
//
//    → And creates their objects automatically
//
@SpringBootApplication
public class ResearchAssistantApplication {



    // main() method is the entry point of the Java application
    //
    // When you run this file,
    // execution starts from here
    //
    public static void main(String[] args) {


        // SpringApplication.run() starts the Spring Boot application
        //
        // It performs following tasks:
        //
        // 1. Starts embedded server (Tomcat)
        //
        // 2. Creates Spring Container
        //
        // 3. Initializes all Beans
        //
        // 4. Performs Component Scanning
        //
        // 5. Starts your backend application
        //
        // ResearchAssistantApplication.class
        // → This tells Spring Boot the main class
        //
        // args → command line arguments
        //
        SpringApplication.run(ResearchAssistantApplication.class, args);
    }

}