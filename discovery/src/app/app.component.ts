import { Component } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';
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

  ngOnInit() {
    this.doUserCheck()
    console.log(this.userLoggedIn)
  }

  doUserCheck() {
    this.cookie.get('jwt') != '' || this.cookie.get('jwt') != undefined ? 
    this.userLoggedIn = true : this.userLoggedIn = false
  }

}
