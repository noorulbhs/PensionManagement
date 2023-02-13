import { Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-error',
  templateUrl: './error.component.html',
  styleUrls: ['./error.component.css']
})
export class ErrorComponent implements OnInit{

  @Input() errorMessage:String=null;
  @Input() isError;

  constructor() { }


  ngOnInit(): void {
  }

  closeError(){
    this.isError=false;
  }
}
