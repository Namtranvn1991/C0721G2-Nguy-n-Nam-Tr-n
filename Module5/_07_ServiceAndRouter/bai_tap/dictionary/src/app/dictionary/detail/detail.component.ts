import {Component, OnInit} from '@angular/core';
import {DictionaryService} from '../../service/dictionary.service';
import {ActivatedRoute, ParamMap} from '@angular/router';
import {Vocabulary} from '../../model/vocabulary';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {
  vocabulary: Vocabulary;

  constructor(private service: DictionaryService,
              private activeRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.activeRoute.paramMap.subscribe((pram: ParamMap) => {
      const id = pram.get('id');
      this.vocabulary = this.service.getById(parseInt(id));
    });
  }

}
