import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {MainLayoutComponent} from './main-layout/main-layout.component';
import {LoginComponent} from './login/login.component';
import {SignComponent} from './sign/sign.component';

export const routes: Routes = [
  {
    path: '',
    component: MainLayoutComponent
  },
    {
      path:'login',
      component:LoginComponent

    },
    {
      path:'sign',
      component:SignComponent
    }
]
;

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class MainLayoutRoutingModule {
}
