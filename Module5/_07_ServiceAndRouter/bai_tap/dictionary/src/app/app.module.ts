import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DictionaryComponent } from './dictionary/dictionary.component';
import { PageComponent } from './dictionary/page/page.component';
import { DetailComponent } from './dictionary/detail/detail.component';

@NgModule({
  declarations: [
    AppComponent,
    DictionaryComponent,
    PageComponent,
    DetailComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
