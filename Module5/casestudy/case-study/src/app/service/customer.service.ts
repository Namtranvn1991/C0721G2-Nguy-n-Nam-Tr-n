import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Customer} from '../mode/customer/customer';
import {CustomerType} from '../mode/customer/customer-type';
import {Observable} from 'rxjs';
import {AbstractControl} from '@angular/forms';

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

  getById(id: number): Observable<Customer>{
    return this.http.get<Customer>(this.urlCustomer + '/' + id);
  }

  getCusType(){
    return this.http.get<CustomerType[]>(this.urlCusType);
  }

  create(customer: Customer): Observable<Customer>{
    return this.http.post<Customer>(this.urlCustomer, customer);
  }

  edit(customer: Customer): Observable<Customer>{
    return this.http.put<Customer>(this.urlCustomer + '/' + customer.id, customer);
  }

  delete(id: number): Observable<Customer>{
    return this.http.delete<Customer>(this.urlCustomer + '/' + id);
  }
  // name_like=an&address_like=

  search(name: string, address: string): Observable<Customer[]>{
    if (name && address){
      return this.http.get<Customer[]>(this.urlCustomer + '?name_like=' + name + '&address_like=' + address);
    } else if (!address && !name){
      this.getAll();
    } else if (!name) {
      return this.http.get<Customer[]>(this.urlCustomer + '?address_like=' + address);
    } else {
      return this.http.get<Customer[]>(this.urlCustomer + '?name_like=' + name);
    }
  }
}
