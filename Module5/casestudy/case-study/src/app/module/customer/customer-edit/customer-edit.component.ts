import {Component, OnInit} from '@angular/core';
import {Customer} from '../../../mode/customer/customer';
import {CustomerService} from '../../../service/customer.service';
import {Subscription} from 'rxjs';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {CustomerType} from '../../../mode/customer/customer-type';

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.css']
})
export class CustomerEditComponent implements OnInit {
  customer: Customer;
  private subscription: Subscription | undefined;
  id: number;
  form: FormGroup = this.formBuilder.group(
    {
      id: [''],
      name: ['', [Validators.required, Validators.pattern('[A-Z][a-z]*([ ][A-Z][a-z]*)*')]],
      dateOfBirth: ['', [Validators.required]],
      gender: ['', [Validators.required]],
      idCard: ['', [Validators.required, Validators.pattern('^\\d{9}$|^\\d{12}$')]],
      phone: ['', [Validators.required, Validators.pattern('^090\\d{7}$|^091\\d{7}$|^[(]84[)][+]90\\d{7}$|^[(]84[)][+]91\\d{7}$')]],
      email: ['', [Validators.required, Validators.email]],
      address: ['', [Validators.required]],
      cusType: [''],
    }, {validators: this.checkDOB.bind(this)}
  );
  cusTypes: CustomerType[];
  errorMessages = {
    name: [
      {type: 'required', message: 'name is required.'},
      {type: 'pattern', message: 'Please enter a valid name!'}
    ],
    email: [
      {type: 'required', message: 'email is required.'},
      {type: 'email', message: 'Please enter a valid e-mail address!'}
    ],
    phone: [
      {type: 'required', message: 'phone is required.'},
      {type: 'pattern', message: 'phoneNumber wrong format 090xxxxxxx  091xxxxxxx (84)+90xxxxxxx (84)+91xxxxxxx'}
    ],
    idCard: [
      {type: 'required', message: 'idCard is required.'},
      {type: 'pattern', message: 'XXXXXXXXX or XXXXXXXXXXXX (X 0-9)'}
    ],
  };

  constructor(private customerService: CustomerService, private activatedRoute: ActivatedRoute,
              private formBuilder: FormBuilder, private router: Router) {
  }

  ngOnInit(): void {
    // this.form = this.formBuilder.group(
    //   {
    //     name: ['', [Validators.required, Validators.pattern('[A-Z][a-z]*([ ][A-Z][a-z]*)*')]],
    //     dateOfBirth: ['' , [Validators.required]],
    //     gender: ['', [Validators.required]],
    //     idCard: ['', [Validators.required, Validators.pattern('^\\d{9}$|^\\d{12}$')]],
    //     phone: ['', [Validators.required, Validators.pattern('^090\\d{7}$|^091\\d{7}$|^[(]84[)][+]90\\d{7}$|^[(]84[)][+]91\\d{7}$')]],
    //     email: ['', [Validators.required, Validators.email]],
    //     address: ['', [Validators.required]],
    //     cusType: [''],
    //   }, {validators: this.checkDOB.bind(this)}
    // );
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
    });
    this.subscription = this.customerService.getById(this.id).subscribe(
      data => {
        this.customer = data;
        console.log(this.customer);
        this.form.setValue(this.customer);
      }, error => {
        console.log(error);
      }
    );
    this.subscription = this.customerService.getCusType().subscribe(
      data => {
        this.cusTypes = data;
      }, error => {
        console.log(error);
      }
    );
  }

  name() {
    return this.form.get('name');
  }

  idCard() {
    return this.form.get('idCard');
  }

  phone() {
    return this.form.get('phone');
  }

  email() {
    return this.form.get('email');
  }

  checkDOB(formGroup: FormGroup) {
    const {value: dateOfBirth} = formGroup.get('dateOfBirth');
    const dOB = new Date(dateOfBirth);
    const dateNow = Date.now();
    // @ts-ignore
    const timeDiff = Math.abs(dateNow - dOB);
    const age = Math.floor((timeDiff / (1000 * 3600 * 24)) / 365);
    return age >= 18 ? null : {ageMustBe18: true};
  }

  compareFn(c1: CustomerType, c2: CustomerType): boolean {
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
  }

  onSubmit() {
    console.log(this.form.value);
    this.customerService.edit(this.form.value).subscribe(data => {
      console.log(data);
      this.router.navigateByUrl('/customer');
    }, error => {
      console.log(error);
    });
  }
}
