import { Component, OnInit } from '@angular/core';
import { faCoffee } from '@fortawesome/free-solid-svg-icons';
import { User } from '../../models/User.model';
import { AuthService} from "../../services/auth/auth.service";

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
  constructor(private srv: AuthService) { }

  ngOnInit(): void {
  }

  login() {
    this.srv.doAuthentication(this.authForm).subscribe((data) => {
      console.warn(data)
    })
}
}
