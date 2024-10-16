package com.example.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.example.entity.User;
import com.example.entity.UserPayload;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class GeminiAiService {

    @Value("${gemini.api.key}")
    private String apiKey;

    private final WebClient geminiWebClient;

    @Autowired
    public GeminiAiService(@Qualifier("Geminiclient") WebClient geminiWebClient) {
        this.geminiWebClient = geminiWebClient;
    }

    public String generateText(String prompt, String modelName) {
        User user = new User(prompt);  // Create User entity with the provided prompt
        UserPayload userPayload = new UserPayload(user.getText());  // Convert User to UserPayload

        String defaultModel = "models/gemini-1.5-flash";
        String model = (modelName != null && !modelName.isEmpty()) ? modelName : defaultModel;

        // Construct the URI with the API key
        String uri = "/v1beta/" + model + ":generateContent?key=" + apiKey;

        try {
            // Make the API call and retrieve the response
            String response = geminiWebClient.post()
                    .uri(uri)
                    .bodyValue(userPayload)  // Send the payload as the request body
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();  // Block to return a String response

            // Parse the response to extract the "text" field
//            ObjectMapper objectMapper = new ObjectMapper();
//            JsonNode rootNode = objectMapper.readTree(response);
//            return rootNode.path("candidates").get(0).path("content").path("parts").get(0).path("text").asText();
            return response;

        } catch (WebClientResponseException e) {
            // Handle errors from the API call
            System.err.println("Error during API call: " + e.getMessage());
            return "An error occurred: " + e.getMessage();
        } catch (Exception e) {
            // Handle any other errors that might occur
            e.printStackTrace();
            return "An unexpected error occurred.";
        }
    }
}