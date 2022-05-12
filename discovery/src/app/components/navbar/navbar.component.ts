import { Component, OnInit } from '@angular/core';
import { faGear, faRightToBracket, faUser } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {
  faUser = faUser
  faRightToBracket = faRightToBracket
  faGear = faGear

  constructor() { }

  ngOnInit(): void {
  }

}
