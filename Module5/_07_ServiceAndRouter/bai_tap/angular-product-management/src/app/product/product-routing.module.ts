import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ProductListComponent} from './product-list/product-list.component';
import {ProductCreateComponent} from './product-create/product-create.component';
import {ProductDeleteComponent} from './product-delete/product-delete.component';
import {ProductDetailComponent} from './product-detail/product-detail.component';


// @ts-ignore
const routes: Routes = [{
  path: 'list',
  component: ProductListComponent
}, {
  path: 'create',
  component: ProductCreateComponent
}, {
  path: 'edit/:id',
  component: ProductDetailComponent
}, {
  path: 'delete/:id',
  component: ProductDeleteComponent
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProductRoutingModule { }
