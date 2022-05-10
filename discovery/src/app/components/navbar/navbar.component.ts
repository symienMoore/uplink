import { Component, OnInit } from '@angular/core';
import { faRightToBracket, faUser } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {
  faUser = faUser
  faRightToBracket = faRightToBracket
  constructor() { }

  ngOnInit(): void {
  }

}
