import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-color',
  templateUrl: './color.component.html',
  styleUrls: ['./color.component.css']
})
export class ColorComponent implements OnInit {
  colorList: Array<string> = ['#ef9a9a', '#e57373', '#ef5350',
    '#f44336', '#f48fb1', '#f06292',
    '#ec407a', '#e91e63', '#ce93d8',
    '#ba68c8', '#ab47bc', '#9c27b0',
    '#b39ddb', '#9575cd', '#7e57c2', '#673AB7'];
  colorPicker = '#ef9a9a' ;

  constructor() {
  }
  ngOnInit(): void {
  }
  public pickColor(color: string){
    this.colorPicker = color;
  }
}
