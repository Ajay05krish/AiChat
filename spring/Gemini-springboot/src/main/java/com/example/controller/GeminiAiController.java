package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.GeminiAiService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController // Common path for all endpoints in this controller
public class GeminiAiController {

    private final GeminiAiService geminiAiService;

    @Autowired
    public GeminiAiController(GeminiAiService geminiAiService) {
        this.geminiAiService = geminiAiService;
    }

    @GetMapping("/generate-content")
    public String generateContent(@RequestParam String prompt) {
        // Block the reactive stream and return the result as a String
        return geminiAiService.generateText(prompt, null);
    }

    @GetMapping("/hello")
    public String getuser() {
        System.out.println("controller initiated");
        return "success";
    }
}
