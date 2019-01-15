import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule} from '@angular/router';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {DialogModule} from 'primeng/dialog';
import {PersonalCabinetRouting} from './personal-cabinet.routing';
import {LoginComponent} from './login/login.component';
import {RegistrationComponent} from './registration/registration.component';
import {CalendarModule} from 'primeng/calendar';
import {CabComponent} from './cab/cab.component';
import {CheckboxModule} from 'primeng/checkbox';
import {SelectButtonModule} from 'primeng/selectbutton';
import {PersonalCabinetService} from './personal-cabinet.service';
import {RadioButtonModule} from 'primeng/radiobutton';


@NgModule({
  imports: [
    CalendarModule,
    RouterModule,
    PersonalCabinetRouting,
    CommonModule,
    DialogModule,
    FormsModule,
    ReactiveFormsModule,
    CheckboxModule,
    RadioButtonModule,
    SelectButtonModule
  ],
  declarations: [LoginComponent, RegistrationComponent, CabComponent],
  providers: [PersonalCabinetService]
})
export class PersonalCabinetModule {
}



