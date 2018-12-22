import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from './login/login.component';
import {RegistrationComponent} from './registration/registration.component';

export const routes: Routes = [
    {
      path:'login',
      component:LoginComponent

    },
    {
      path:'login/registration',
      component:RegistrationComponent
    }
]
;

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class PersonalCabinetRouting {
}
