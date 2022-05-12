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
  user?: User = new User()
  authForm = {
    email: '',
    password: ''
  }

  dataRes: any
  constructor(private srv: AuthService) { }

  ngOnInit(): void {
  }

  login() {
    this.srv.doAuthentication(this.authForm)
    .subscribe(res => {
      // console.log(res)
      this.dataRes = res
      console.log('this is the response: ' + this.dataRes.value.value)
    })
}

}
