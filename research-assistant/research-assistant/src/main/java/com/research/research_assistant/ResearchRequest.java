package com.research.research_assistant;


// Lombok annotation
// @Data automatically generates:
//
// • getters
// • setters
// • toString()
// • equals()
// • hashCode()
//
// This reduces boilerplate code
//
// Example:
// getContent()
// setContent()
// getOperation()
// setOperation()
//
import lombok.Data;



// @Data generates all required methods automatically
@Data
public class ResearchRequest {



    // content field stores the actual text sent from frontend
    //
    // Example:
    //
    // "content": "Artificial Intelligence is transforming industries"
    //
    // This text comes from:
    //
    // Chrome Extension
    //
    // and is used for processing like:
    //
    // • Summarization
    // • Explanation
    // • Email generation
    //
    private String content;




    // operation field stores the type of operation to perform
    //
    // Example:
    //
    // "operation": "summarize"
    //
    // Other examples:
    //
    // "operation": "explain"
    // "operation": "rewrite"
    //
    // This helps backend decide what to do with content
    //
    private String operation;
}