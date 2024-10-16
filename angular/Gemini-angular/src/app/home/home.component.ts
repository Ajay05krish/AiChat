import { Component } from '@angular/core';
import { GeminiAiService } from '../_services/gemini-ai.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  prompt: string = ''; // Holds the user input prompt
  messages: { text: string; isUser: boolean }[] = []; // Array to hold conversation messages
  darkMode: boolean = false; // Flag for dark mode

  constructor(private geminiAiService: GeminiAiService) { 
    // Load saved theme on component init
  }

  onGenerate() {
    // Check if the prompt is not empty
    if (this.prompt) {
      // Add user message to the messages array
      this.messages.push({ text: this.prompt, isUser: true });
  
      // Call the Gemini AI service to generate text based on the prompt
      this.geminiAiService.generateText(this.prompt).subscribe(
        (response: any) => {
          console.log('Full response:', response);
  
          // Check if there are candidates in the response
          if (response.candidates && response.candidates.length > 0) {
            const candidate = response.candidates[0]; // Get the first candidate
            const content = candidate.content;
  
            // Check if the content has parts
            if (content.parts && content.parts.length > 0) {
              const generatedText = content.parts[0].text; // Get the generated text
  
              // Add the generated response to the messages array
              this.messages.push({ text: generatedText, isUser: false });
            }
          }
        },
        (error: any) => {
          // Log the error if there is an issue generating content
          console.error('Error generating content:', error);
        }
      );
  
      // Clear input after sending
      this.prompt = '';
    }
  }
  

}