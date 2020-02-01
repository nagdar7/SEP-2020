import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { routing } from "./app.routes";
import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { NewMagazineComponent } from './components/new-magazine/new-magazine.component';
import { MagazineComponent } from './components/magazine/magazine.component';
import { HomeComponent } from './components/home/home.component';
import { PaymentComponent } from './components/payment/payment.component';


import { MagazineService } from './services/magazine.service';
import { NewMagazineService } from './services/newMagazine.service';
import { PaymentService } from './services/payment.service';

import { HttpClientModule, HttpClient } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    NewMagazineComponent,
    MagazineComponent,
    HomeComponent,
    PaymentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    routing,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    MagazineService,
    NewMagazineService,
    PaymentService,
    HttpClientModule,
    HttpClient
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
