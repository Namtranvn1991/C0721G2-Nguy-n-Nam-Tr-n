import {Component, OnChanges, OnInit} from '@angular/core';
import {Medical} from '../../model/medical';
import {Subscription} from 'rxjs';
import {ServiceService} from '../../service/service.service';

@Component({
  selector: 'app-medical',
  templateUrl: './medical.component.html',
  styleUrls: ['./medical.component.css']
})
export class MedicalComponent implements OnInit {

  medicalList: Medical[] | undefined;
  private subscription: Subscription | undefined;
  p = 1;
  page = 0;
  pages: Array<number>;

  constructor(private service: ServiceService) { }

  ngOnInit(): void {
   this.sub();
  }

  sub(){
    this.subscription = this.service.getAll(this.page).subscribe(
      data => {
        this.medicalList = data['content'];
        this.pages = new Array(data['totalPages']);
        console.log(data);
      }, error => {
        console.log(error);
      }
    );
  }

  delete(id: string) {
    this.service.delete(id).subscribe(data => {
      this.ngOnInit();
    }, error => {
      console.log(error);
    });
  }


  setPage(i: number) {
    this.page = i;
    console.log(this.page);
    this.sub();
  }
}
