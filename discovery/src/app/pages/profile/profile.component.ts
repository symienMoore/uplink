import { Component, OnInit } from '@angular/core';
import { AuthService} from "../../services/auth/auth.service";
import {Observable} from "rxjs";
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {

  constructor(private svc: AuthService, private cookie: CookieService) { }

  ngOnInit(): void {
    this.getUserInfo()
  }

  getUserInfo() {
    this.svc.getUser().subscribe(data => {
      console.warn(JSON.parse(this.jwt).value.toString())
      console.log(data)
    })
  }
  jwt = this.cookie.get("jwt")
  // test: Observable<any> =  new Observable(subscriber => {
  //   subscriber.next("this is the value: " + this.jwt)
  // })


}
