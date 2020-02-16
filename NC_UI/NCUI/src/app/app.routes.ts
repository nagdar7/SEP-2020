import { Authorized } from "./guard/authorized.guard";
import { LoginComponent } from "./components/login/login.component";
import { Notauthorized } from "./guard/notauthorized.guard";
import { RegistrationComponent } from "./components/registration/registration.component";
import { ModuleWithProviders } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { NewMagazineComponent } from "./components/new-magazine/new-magazine.component";
import { MagazineComponent } from "./components/magazine/magazine.component";
import { HomeComponent } from "./components/home/home.component";
import { PaymentSuccessComponent } from "src/app/components/paymentSuccess/paymentSuccess.component";
import { PaymentFailedComponent } from "src/app/components/paymentFailed/paymentFailed.component";
import { PaymentErrorComponent } from "src/app/components/paymentError/paymentError.component";

const appRoutes: Routes = [
  {
    path: "",
    component: HomeComponent
  },
  {
    path: "sviCasopisi",
    component: MagazineComponent,
    canActivate: [Authorized]
  },
  {
    path: "noviCasopis",
    component: NewMagazineComponent,
    canActivate: [Authorized]
  },
  {
    path: "paymentSuccess",
    component: PaymentSuccessComponent,
    canActivate: [Authorized]
  },
  {
    path: "paymentFailed",
    component: PaymentFailedComponent,
    canActivate: [Authorized]
  },
  {
    path: "paymentError",
    component: PaymentErrorComponent,
    canActivate: [Authorized]
  },
  {
    path: "register",
    component: RegistrationComponent,
    canActivate: [Notauthorized]
  },
  {
    path: "login",
    component: LoginComponent,
    canActivate: [Notauthorized]
  }
];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);
