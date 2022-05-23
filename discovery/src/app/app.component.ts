import { Component } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';
import { Observable } from 'rxjs';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'discovery';

  userLoggedIn: Boolean = false;

  constructor(private cookie: CookieService) {

  }

  jwt = this.cookie.get("jwt")

  obs = new Observable((o) => {
    o.next(this.jwt + ': this is the data')
  })

  ngOnInit() {
    this.checksForUser()
  }

  checksForUser() {
    this.obs.subscribe(data => {
      console.log(data)
      if (data == " " || data == null) {
        this.userLoggedIn = false
      } else {
        this.userLoggedIn = true
      }
    })
  }

  

}
