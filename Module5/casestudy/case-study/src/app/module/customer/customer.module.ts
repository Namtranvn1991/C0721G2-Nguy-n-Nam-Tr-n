import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CustomerRoutingModule } from './customer-routing.module';
import { CustomerListComponent } from './customer-list/customer-list.component';
import { CustomerCreateComponent } from './customer-create/customer-create.component';
import {ReactiveFormsModule} from '@angular/forms';
import { CustomerEditComponent } from './customer-edit/customer-edit.component';


@NgModule({
  declarations: [CustomerListComponent, CustomerCreateComponent, CustomerEditComponent],
  exports: [
    CustomerListComponent
  ],
    imports: [
        CommonModule,
        CustomerRoutingModule,
        ReactiveFormsModule
    ]
})
export class CustomerModule { }
