import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule} from '@angular/router';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {DialogModule} from 'primeng/dialog';
import {PersonalCabinetRouting} from './personal-cabinet.routing';
import {LoginComponent} from './login/login.component';
import {RegistrationComponent} from './registration/registration.component';
import {CalendarModule} from 'primeng/calendar';

@NgModule({
  imports: [
    CalendarModule,

    RouterModule,
    PersonalCabinetRouting,
    CommonModule,
    FormsModule,
    DialogModule,
    ReactiveFormsModule
  ],
  declarations: [LoginComponent, RegistrationComponent]
})
export class PersonalCabinetModule {
}
