import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { NewMagazineComponent} from './components/new-magazine/new-magazine.component';
import { MagazineComponent } from './components/magazine/magazine.component';
import { HomeComponent } from './components/home/home.component';
import { PaymentSuccessComponent } from 'src/app/components/paymentSuccess/paymentSuccess.component';
import { PaymentFailedComponent } from 'src/app/components/paymentFailed/paymentFailed.component';
import { PaymentErrorComponent } from 'src/app/components/paymentError/paymentError.component';


const appRoutes : Routes =
  [
    {
      path : '',
      component : HomeComponent
    },
    {
      path : 'sviCasopisi',
      component : MagazineComponent
    },
    {
      path : 'noviCasopis',
      component : NewMagazineComponent
    },
    {
      path : 'paymentSuccess',
      component : PaymentSuccessComponent
    },
    {
      path : 'paymentFailed',
      component : PaymentFailedComponent
    },
    {
      path : 'paymentError',
      component : PaymentErrorComponent
    }
  ];

export const routing : ModuleWithProviders = RouterModule.forRoot(appRoutes);

