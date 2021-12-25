import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {PageComponent} from './dictionary/page/page.component';
import {DetailComponent} from './dictionary/detail/detail.component';


const routes: Routes = [
  {
    path: 'dictionary',
    component: PageComponent
  },
  {
    path: 'dictionary/detail/:id',
    component: DetailComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
