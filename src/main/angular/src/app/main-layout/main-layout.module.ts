import {CommonModule} from '@angular/common';
import {NgModule} from '@angular/core';

import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MainLayoutService} from './main-layout.service';
import {MainLayoutComponent} from './main-layout/main-layout.component';
import {RouterModule} from '@angular/router';
import {DialogModule} from 'primeng/dialog';
import {LoginComponent} from '../personal-cabinet/login/login.component';
import {MainLayoutRoutingModule} from './main-layout.routing';
import  {RegistrationComponent} from '../personal-cabinet/registration/registration.component';
import {MultiSelectModule} from 'primeng/multiselect';
import {RadioButtonModule} from 'primeng/radiobutton';

@NgModule({
  imports: [
    RouterModule,
    MainLayoutRoutingModule,
    CommonModule,
    FormsModule,
    DialogModule,
    ReactiveFormsModule,
    MultiSelectModule,
    RadioButtonModule
  ],
  providers: [MainLayoutService],
  declarations: [MainLayoutComponent]
})
export class MainLayoutModule {
}
