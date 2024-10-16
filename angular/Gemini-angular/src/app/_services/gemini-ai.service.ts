import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

// Define the structure of the response for better type safety
interface ContentPart {
  text: string;
}

interface Candidate {
  content: {
    parts: ContentPart[];
  };
}

interface GeminiResponse {
  candidates: Candidate[];
}

@Injectable({
  providedIn: 'root'
})
export class GeminiAiService {
  private apiUrl = 'http://localhost:8090/generate-content'; // Update this to your backend API URL

  constructor(private http: HttpClient) { }

  // Adjust the return type to match the structure of the response
  generateText(prompt: string): Observable<GeminiResponse> {
    return this.http.get<GeminiResponse>(this.apiUrl, { params: { prompt } });
  }
}
