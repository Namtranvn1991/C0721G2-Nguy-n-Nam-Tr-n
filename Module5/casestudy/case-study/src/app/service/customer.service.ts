import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Customer} from '../mode/customer/customer';
import {CustomerType} from '../mode/customer/customer-type';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private urlCustomer = 'http://localhost:3000/customer';
  private urlCusType = 'http://localhost:3000/customer_type';

  constructor(private http: HttpClient) { }

  getAll(): Observable<Customer[]>{
    return this.http.get<Customer[]>(this.urlCustomer);
  }

  getCusType(){
    return this.http.get<CustomerType[]>(this.urlCusType);
  }

  create(customer: Customer): Observable<Customer>{
    return this.http.post<Customer>(this.urlCustomer, customer);
  }

  edit(id: number, customer: Customer): Observable<Customer>{
    return this.http.put<Customer>(this.urlCustomer + '/' + id, customer);
  }
}
