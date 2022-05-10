import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  API_URL: string = "http://localhost:8080"
  API_LOGIN: string = `${this.API_URL}/api/login`

  constructor(private http: HttpClient) { }

  doAuthentication(request: object) {
    // @ts-ignore
    return this.http.post(`${this.API_LOGIN}`, request)
  }

}
