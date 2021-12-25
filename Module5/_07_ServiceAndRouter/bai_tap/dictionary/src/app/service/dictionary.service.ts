import { Injectable } from '@angular/core';
import {Vocabulary} from '../model/vocabulary';

@Injectable({
  providedIn: 'root'
})
export class DictionaryService {
  dictionary: Vocabulary[] = [
    {
      id: 1,
      eng: 'one',
      vie: 'một'
    },
    {
      id: 2,
      eng: 'two',
      vie: 'hai'
    },
    {
      id: 3,
      eng: 'three',
      vie: 'ba'
    },
    {
      id: 4,
      eng: 'four',
      vie: 'bốn'
    },
    {
      id: 5,
      eng: 'five',
      vie: 'năm'
    }
  ];


  constructor() { }

  getAll(){
    return this.dictionary;
  }

  getById(id: number) {
    return this.dictionary.find(x => x.id === id);
  }
}
