import { Component, OnInit } from '@angular/core';
import { faCoffee } from '@fortawesome/free-solid-svg-icons';
import { User } from '../../models/User.model';
import { AuthService} from "../../services/auth/auth.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  faCoffee = faCoffee
  user?: User = new User()
  authForm = {
    email: '',
    password: ''
  }

  constructor(private srv: AuthService) { }

  ngOnInit(): void {
  }

  login() {
    this.srv.doAuthentication(this.authForm).subscribe((data) => {
      console.warn(data)
    })
}

}
