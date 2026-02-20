package com.research.research_assistant;


// ObjectMapper is from Jackson library
// It is used to convert:
//
// JSON → Java Object
// Java Object → JSON
//
// Example:
//
// JSON → GeminiResponse
//
import com.fasterxml.jackson.databind.ObjectMapper;



// @Bean and @Configuration annotations
//
// @Configuration → marks this class as Spring Configuration class
// Used to define Spring Beans
//
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



// WebClient is used to call external APIs
//
// Example:
//
// Gemini API
//
// It is part of Spring WebFlux
//
import org.springframework.web.reactive.function.client.WebClient;



// @Configuration tells Spring:
//
// This class contains Bean definitions
//
// Spring will automatically execute this class
//
@Configuration
public class WebClientConfig {




    // @Bean annotation tells Spring:
    //
    // Create this object
    //
    // And store it in Spring Container
    //
    // This object can be injected anywhere using @Autowired
    //
    @Bean
    public WebClient.Builder webClientBuilder() {



        // WebClient.builder() creates WebClient Builder object
        //
        // WebClient is used for:
        //
        // • Calling Gemini API
        // • Calling external REST APIs
        //
        // Builder is used to configure WebClient
        //
        // Example:
        //
        // base URL
        // headers
        //
        return WebClient.builder();
    }






    // This Bean creates ObjectMapper object
    //
    // ObjectMapper is used to:
    //
    // Convert JSON → Java
    //
    // Example:
    //
    // Gemini JSON response → GeminiResponse object
    //
    @Bean
    public ObjectMapper objectMapper() {


        // Creates new ObjectMapper instance
        //
        // Spring will store this in Spring Container
        //
        // and reuse it whenever needed
        //
        return new ObjectMapper();
    }

}