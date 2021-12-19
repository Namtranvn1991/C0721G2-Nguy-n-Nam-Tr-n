import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {
  number1: number;
  number2: number;
  result;

  constructor() { }

  ngOnInit(): void {
  }

  calculate(value){
    console.log(value);
    console.log(this.number1);
    console.log(typeof this.number1 === 'string');
    console.log(this.number2);
    if (value === '1'){
      this.result = this.number1 + this.number2;
    } else if ( value === '2'){
      this.result = this.number1 - this.number2;
    } else if ( value === '3'){
      this.result = this.number1 * this.number2;
    } else if ( value === '4'){
      if (this.number2 === 0){
        this.result = 'cant div zero';
      } else {
        this.result = this.number1 / this.number2;
      }
    }
    console.log(this.result);
  }
}
