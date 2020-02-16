import { RegistrationComponent } from "./components/registration/registration.component";
import { LoginComponent } from "./components/login/login.component";
import { Notauthorized } from "./guard/notauthorized.guard";
import { Authorized } from "./guard/authorized.guard";
import { Editor } from "./guard/editor.guard";
import { JwtInterceptor } from "./helpers/jwt.interceptor";
import { ErrorInterceptor } from "./helpers/error.interceptor";
import { UserService } from "./services/user.service";
import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import { FormsModule } from "@angular/forms";

import { routing } from "./app.routes";
import { AppRoutingModule } from "./app-routing.module";

import { AppComponent } from "./app.component";
import { NewMagazineComponent } from "./components/new-magazine/new-magazine.component";
import { MagazineComponent } from "./components/magazine/magazine.component";
import { HomeComponent } from "./components/home/home.component";
import { PaymentComponent } from "./components/payment/payment.component";
import { PaymentSuccessComponent } from "./components/paymentSuccess/paymentSuccess.component";
import { PaymentFailedComponent } from "./components/paymentFailed/paymentFailed.component";
import { PaymentErrorComponent } from "./components/paymentError/paymentError.component";

import { MagazineService } from "./services/magazine.service";
import { NewMagazineService } from "./services/newMagazine.service";
import { PaymentService } from "./services/payment.service";

import {
  HttpClientModule,
  HttpClient,
  HTTP_INTERCEPTORS
} from "@angular/common/http";
import { Author } from "./guard/author.guard";

@NgModule({
  declarations: [
    AppComponent,
    NewMagazineComponent,
    MagazineComponent,
    HomeComponent,
    PaymentComponent,
    PaymentSuccessComponent,
    PaymentFailedComponent,
    PaymentErrorComponent,
    LoginComponent,
    RegistrationComponent
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
    UserService,
    PaymentService,
    HttpClientModule,
    HttpClient,
    Author,
    Editor,
    Authorized,
    Notauthorized,
    { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {}
