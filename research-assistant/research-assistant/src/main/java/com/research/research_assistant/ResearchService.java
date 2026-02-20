package com.research.research_assistant;

// ObjectMapper is used to convert JSON response into Java object
// Example:
// JSON → GeminiResponse object
import com.fasterxml.jackson.databind.ObjectMapper;


// @Value is used to read values from application.properties file
//
// Example:
// gemini.api.url
// gemini.api.key
//
import org.springframework.beans.factory.annotation.Value;


// @Service marks this class as Service Layer
//
// Service Layer contains business logic
//
// Spring automatically creates object of this class
//
import org.springframework.stereotype.Service;


// WebClient is used to call external APIs
//
// Example:
// Gemini API
//
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;



// Marks this class as Spring Service Component
@Service
public class ResearchService {



    // Reads Gemini API URL from application.properties
    //
    // application.properties:
    // gemini.api.url=${GEMINI_URL}
    //
    @Value("${gemini.api.url}")
    private String geminiApiUrl;



    // Reads Gemini API Key from application.properties
    //
    // application.properties:
    // gemini.api.key=${GEMINI_KEY}
    //
    @Value("${gemini.api.key}")
    private String geminiApiKey;



    // WebClient is used to call Gemini API
    //
    // final means value cannot be changed
    //
    private final WebClient webClient;



    // ObjectMapper is used to convert JSON → Java object
    //
    private final ObjectMapper objectMapper;




    // Constructor Injection
    //
    // Spring automatically injects:
    //
    // WebClient.Builder
    // ObjectMapper
    //
    public ResearchService(WebClient.Builder webClientBuilder, ObjectMapper objectMapper) {

        // Build WebClient object
        this.webClient = webClientBuilder.build();

        // Assign ObjectMapper
        this.objectMapper = objectMapper;
    }




    // Main business logic method
    //
    // This method:
    //
    // 1. Receives request from Controller
    // 2. Builds prompt
    // 3. Calls Gemini API
    // 4. Extracts response
    // 5. Returns result
    //
    public String processContent(ResearchRequest request) {


        // Build prompt based on operation
        //
        // Example:
        // summarize
        //
        String prompt = buildPrompt(request);




        // Build request body to send to Gemini API
        //
        // Gemini expects JSON in this format:
        //
        // {
        //   "contents": [
        //     {
        //       "parts": [
        //         {
        //           "text": "prompt text"
        //         }
        //       ]
        //     }
        //   ]
        // }
        //
        Map<String, Object> requestBody = Map.of(

                "contents", new Object[] {

                        Map.of("parts", new Object[]{

                                Map.of("text", prompt)
                        })
                }
        );




        // Send POST request to Gemini API
        //
        String response = webClient.post()

                // API URL + API Key
                .uri(geminiApiUrl + geminiApiKey)


                // Attach JSON body
                .bodyValue(requestBody)


                // Send request
                .retrieve()


                // Convert response into String
                .bodyToMono(String.class)


                // block() waits for response synchronously
                .block();




        // Extract actual text from JSON response
        //
        return extractTextFromResponse(response);
    }




    // Method to extract text from Gemini API JSON response
    //
    private String extractTextFromResponse(String response) {

        try {


            // Convert JSON String → GeminiResponse object
            GeminiResponse geminiResponse =
                    objectMapper.readValue(response, GeminiResponse.class);




            // Check candidates exist
            if (geminiResponse.getCandidates() != null &&
                    !geminiResponse.getCandidates().isEmpty()) {



                GeminiResponse.Candidate firstCandidate =
                        geminiResponse.getCandidates().get(0);



                if (firstCandidate.getContent() != null &&

                        firstCandidate.getContent().getParts() != null &&

                        !firstCandidate.getContent().getParts().isEmpty()) {



                    // Return AI generated text
                    return firstCandidate
                            .getContent()
                            .getParts()
                            .get(0)
                            .getText();
                }
            }



            return "No content found in response";



        } catch (Exception e) {


            return "Error Parsing: " + e.getMessage();
        }
    }






    // Method to build prompt for Gemini AI
    //
    private String buildPrompt(ResearchRequest request) {


        // StringBuilder is used to build string efficiently
        StringBuilder prompt = new StringBuilder();



        // Switch based on operation
        //
        switch (request.getOperation()) {


            case "summarize":

                prompt.append(
                        "Provide a clear and concise summary of the following text in a few sentences:\n\n"
                );

                break;



            case "suggest":

                prompt.append(
                        "Based on the following content: suggest related topics and further reading. Format the response with clear headings and bullet points:\n\n"
                );

                break;

            case "points":

                prompt.append(
                        "Provide a clear and concice response with clear headings and bullet points:\n\n"
                );

                break;



            default:


                // If invalid operation
                throw new IllegalArgumentException(
                        "Unknown Operation: " + request.getOperation()
                );
        }



        // Add actual content
        prompt.append(request.getContent());



        // Return final prompt
        return prompt.toString();
    }
}