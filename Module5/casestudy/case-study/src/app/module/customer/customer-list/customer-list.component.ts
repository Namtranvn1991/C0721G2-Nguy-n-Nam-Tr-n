import {Component, OnDestroy, OnInit} from '@angular/core';
import {CustomerService} from '../../../service/customer.service';
import {Customer} from '../../../mode/customer/customer';
import {CustomerType} from '../../../mode/customer/customer-type';
import {Subject, Subscription} from 'rxjs';
import {Router} from '@angular/router';
import {FormBuilder, FormGroup} from '@angular/forms';


@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit, OnDestroy {
  customer: Customer | undefined;
  customerList: Customer[] | undefined;
  cusTypeList: CustomerType[] | undefined;
  private subscription: Subscription | undefined;
  p = 1;
  searchForm: FormGroup = this.fb.group(
    {
      name: [],
      address: []
    });

  constructor(private cusService: CustomerService, private router: Router, private fb: FormBuilder) {
  }

  ngOnInit(): void {
    this.searchForm.reset();
    this.subscription = this.cusService.getAll().subscribe(
      data => {
        this.customerList = data;
      }, error => {
        console.log(error);
      }
    );
    this.subscription = this.cusService.getCusType().subscribe(
      data => {
        this.cusTypeList = data;
      }, error => {
        console.log(error);
      }
    );
  }


  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }

  delete(id: number) {
    this.cusService.delete(id).subscribe(data => {
      console.log(data);
      this.ngOnInit();
    }, error => {
      console.log(error);
    });
  }


  reset() {
    this.ngOnInit();
  }

  search() {
    console.log(this.searchForm.value);
    const name = this.searchForm.get('name').value;
    const address = this.searchForm.get('address').value;
    this.cusService.search(name, address).subscribe(
      data => {
        console.log(data);
        this.customerList = data;
      }, error => {
        console.log(error);
      }
    );
  }
}
