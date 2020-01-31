import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { NewMagazineComponent} from './components/new-magazine/new-magazine.component';
import { MagazineComponent } from './components/magazine/magazine.component';
import { HomeComponent } from './components/home/home.component';


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

  ];

export const routing : ModuleWithProviders = RouterModule.forRoot(appRoutes);

