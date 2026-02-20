package com.research.research_assistant;

// This import is from Jackson library
// JsonIgnoreProperties is used to ignore unknown JSON fields
// If Gemini API returns extra fields that are not present in this class,
// Jackson will ignore them instead of throwing error
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


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
import lombok.Data;


import java.util.List;


// @Data generates getters and setters automatically
@Data

// Ignore unknown properties coming from Gemini API response JSON
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeminiResponse {


    // This field maps to "candidates" in Gemini API JSON response
    //
    // Gemini response structure example:
    //
    // {
    //   "candidates": [
    //     {
    //       "content": {
    //         "parts": [
    //           {
    //             "text": "Summary text"
    //           }
    //         ]
    //       }
    //     }
    //   ]
    // }
    //
    private List<Candidate> candidates;



    // Static inner class representing each candidate
    //
    // candidates → list of Candidate objects
    //
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Candidate {


        // Maps to "content" object inside candidate
        //
        // JSON:
        // "content": { ... }
        //
        private Content content;
    }




    // Static inner class representing content object
    //
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Content {


        // Maps to "parts" array inside content
        //
        // JSON:
        // "parts": [
        //   {
        //     "text": "Summary"
        //   }
        // ]
        //
        private List<Part> parts;
    }




    // Static inner class representing each part
    //
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Part {


        // Maps to "text" field in JSON
        //
        // This contains actual AI generated response
        //
        // Example:
        // "text": "This is summarized content"
        //
        private String text;
    }
}