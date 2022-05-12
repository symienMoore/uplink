import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {CookieService} from 'ngx-cookie-service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
//TODO: set cookie in request?
  API_URL: string = "http://localhost:8080"
  API_LOGIN: string = `${this.API_URL}/api/login`
  API_USER: string = `${this.API_URL}/api/user-profile`

  constructor(private http: HttpClient, private cookie: CookieService) { }

  doAuthentication(request: object) {
    // @ts-ignore
    return this.http.post(`${this.API_LOGIN}`, request)
  }

  getUser() {
    return this.http.get(`${this.API_USER}`)
  }

}
