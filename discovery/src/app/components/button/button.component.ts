import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-button',
  templateUrl: './button.component.html',
  styleUrls: ['./button.component.scss']
})
export class ButtonComponent implements OnInit {
  @Input() btnText: string | undefined
  @Input() txtColor?: string
  @Input() bgColor!: string

  constructor() { }

  ngOnInit(): void {
  }

}
