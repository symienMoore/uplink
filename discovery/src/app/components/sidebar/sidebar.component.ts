import { Component, OnInit } from '@angular/core';
import {faMessage, faTv, faTvAlt, faPeopleGroup} from '@fortawesome/free-solid-svg-icons'
@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss']
})
export class SidebarComponent implements OnInit {
  faTv = faTv
  faMessage = faMessage
  faPeopleGroup = faPeopleGroup
  constructor() { }

  ngOnInit(): void {
  }

}
