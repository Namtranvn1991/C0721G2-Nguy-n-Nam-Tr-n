import { Component, OnInit } from '@angular/core';
import {DictionaryService} from '../../service/dictionary.service';
import {Vocabulary} from '../../model/vocabulary';

@Component({
  selector: 'app-page',
  templateUrl: './page.component.html',
  styleUrls: ['./page.component.css']
})
export class PageComponent implements OnInit {
  dictionary: Vocabulary[];

  constructor(private service: DictionaryService) { }

  ngOnInit(): void {
    this.dictionary = this.service.getAll();
  }

}
