# Spring Boot Application to Invoke Gemini AI Model via API Calls

## 1. Overview

This Spring Boot project integrates the Gemini AI model (models/gemini-1.5-flash) to process prompts and return AI-generated content. The project utilizes `WebClient` to interact with the Gemini API and exposes an endpoint for users to submit their prompts and retrieve responses.

## 2. Prerequisites

- Java 17+ installed
- Spring Boot 2.7+ or 3.x.x
- Maven/Gradle for dependency management
- Access to the Gemini AI API
- API Key for Google Gemini AI service

## 3. Project Setup

### 3.1 Dependencies

Add the necessary dependencies in `pom.xml` (for Maven) or `build.gradle` (for Gradle) to include `WebClient` and other libraries:
- Spring Boot Web dependency
- spring-boot-starter-webflux

### 3.2 Application Properties

Configure the base URL and API key for Gemini AI in `application.properties`:

properties
server.port=8090
gemini.api.key={your_api_key}

To generate the API key:

Login to Gemini AI Studio at https://ai.google.dev/aistudio.
Click on the "Create API Key" button and select your Google Cloud project to generate the key.
If you don’t have a Google Cloud project, create one to generate an API key.
Copy and paste the API key in your application properties.
4. Implementation
4.1 WebClient Configuration
Create a configuration class to set up the WebClient with necessary headers.

4.2 Service Layer
Create a service class to interact with the Gemini AI API.

4.3 Controller Layer
Create a controller to expose an endpoint where users can send prompts and get responses.

4.4 Example API Call
Once the application is running, access the AI model by sending a GET request via Postman:

Example Request: GET http://localhost:8090/generate-content?prompt=Who is Mahatma Gandhi?
Example Response: Mahatma Gandhi: The Father of India Mahatma Gandhi (1869-1948) was a leader of Indian nationalism in British-ruled India. He employed nonviolent civil disobedience to achieve independence for India, widely revered as the Father of India and globally honored for his philosophy of nonviolent resistance.
5. Error Handling
The service gracefully handles errors from the API by catching WebClient response exceptions and returning meaningful error messages.

6. Testing the Endpoint
Use Postman or curl to test the endpoint.

Using curl:
curl -X GET "http://localhost:8090/generate-content?prompt=your_prompt"
Using Postman:
Set the method to GET.
Enter the URL and send the request.


7. Angular Integration
The Angular front end integrates with the Spring Boot backend to allow users to input prompts and receive responses from the Gemini AI model through a User Interface.

Service Layer: An Angular service is responsible for HTTP calls to the Spring Boot API. The service method sends user prompts to the /generate-content endpoint and returns the AI-generated response.
UI Components: A chat interface allows users to type a prompt in an input field and click a send button to initiate a conversation. The response from the AI model displays in the chat area.
Event Handling: An event-handling function processes the user's input, sends the prompt to the backend, and updates the UI with the AI-generated response once received.
Styling: Custom styles differentiate between user and AI messages. User messages are bold and right-aligned, while AI messages are left-aligned.

8. Conclusion
This documentation covers the setup and integration of the Spring Boot and Angular application to work with the Gemini AI model.
The backend handles API requests to Google Gemini AI, and the Angular frontend provides a simple user interface for interaction, 
creating a fully functional AI-powered chat application.
