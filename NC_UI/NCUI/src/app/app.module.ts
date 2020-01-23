import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { routing } from "./app.routes";
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NewMagazineComponent } from './components/new-magazine/new-magazine.component';
import { MagazineComponent } from './components/magazine/magazine.component';
import { HomeComponent } from './components/home/home.component';
import { MagazineService } from './services/magazine.service';
import { HttpClientModule, HttpClient } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    NewMagazineComponent,
    MagazineComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    routing,
    HttpClientModule
  ],
  providers: [
    MagazineService,
    HttpClientModule,
    HttpClient
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
