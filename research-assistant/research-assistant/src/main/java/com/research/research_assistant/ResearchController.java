package com.research.research_assistant;


// Lombok annotation
// @AllArgsConstructor automatically creates a constructor with all fields as parameters
//
// Example generated constructor:
//
// public ResearchController(ResearchService researchService) {
//     this.researchService = researchService;
// }
//
// This is used for Dependency Injection
import lombok.AllArgsConstructor;


// ResponseEntity is used to represent HTTP response
// It contains:
//
// • Response Body
// • Status Code
// • Headers
//
import org.springframework.http.ResponseEntity;


// Import Spring Web annotations
import org.springframework.web.bind.annotation.*;



// @RestController annotation marks this class as REST Controller
//
// It combines:
//
// @Controller
// +
// @ResponseBody
//
// Meaning:
//
// • Handles HTTP requests
// • Returns response in JSON or String format
//
@RestController



// @RequestMapping defines base URL for all APIs in this controller
//
// Base URL:
//
// http://localhost:8080/api/research
//
@RequestMapping("/api/research")



// @CrossOrigin allows requests from different origins
//
// This is required because:
//
// Your frontend (Chrome Extension)
// runs on different origin
//
// Without this, browser blocks request due to CORS error
//
// origins="*" means allow all origins
//
@CrossOrigin(origins = "*")



// Lombok annotation
// Creates constructor automatically
@AllArgsConstructor
public class ResearchController {



    // private → accessible only inside this class
    // final → value cannot be changed
    //
    // ResearchService is Service Layer
    //
    // Spring injects this automatically
    //
    // This is called Dependency Injection
    //
    private final ResearchService researchService;




    // @PostMapping defines HTTP POST API
    //
    // Full URL:
    //
    // http://localhost:8080/api/research/process
    //
    @PostMapping("/process")



    // ResponseEntity<String>
    //
    // ResponseEntity → HTTP Response
    //
    // String → response body type
    //
    public ResponseEntity<String> processContent(



            // @RequestBody is used to receive JSON data from client
            //
            // JSON from frontend is converted into ResearchRequest object
            //
            // Example JSON:
            //
            // {
            //   "content": "some text",
            //   "operation": "summarize"
            // }
            //
            @RequestBody ResearchRequest request
    ) {



        // Calls Service Layer method
        //
        // request contains:
        //
        // content
        // operation
        //
        // Service layer processes content using Gemini API
        //
        String result = researchService.processContent(request);



        // ResponseEntity.ok(result)
        //
        // Returns:
        //
        // HTTP Status: 200 OK
        //
        // Body: result
        //
        return ResponseEntity.ok(result);
    }
}