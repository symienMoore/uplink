import { Component, OnInit } from '@angular/core';
import { User } from '../../models/User.model';
import { AuthService} from '../../services/auth/auth.service';
import { CookieService } from 'ngx-cookie-service'
import { Observable } from 'rxjs';
@Component({
  selector: 'app-authmodal',
  templateUrl: './authmodal.component.html',
  styleUrls: ['./authmodal.component.scss']
})
export class AuthmodalComponent implements OnInit {
  user?: User = new User()
  authForm = {
    email: '',
    password: ''
  }

  constructor(private srv: AuthService, private cookie: CookieService) { }

  ngOnInit(): void {
  }

  login() {
    this.srv.doAuthentication(this.authForm).subscribe((data) => {
      this.cookie.set('jwt', JSON.stringify(data))
      this.authForm.email = ""
      this.authForm.password = ""
    })
}
}
