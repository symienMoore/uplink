import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  API_URL: string = "http://localhost:8080"

  constructor(private http: HttpClient) { }

  createMessage() {
    return this.http.get(`${this.API_URL}/api/create-message`)
  }
}
