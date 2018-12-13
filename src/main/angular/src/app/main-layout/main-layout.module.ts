import {CommonModule} from '@angular/common';
import {NgModule} from '@angular/core';

import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MainLayoutService} from './main-layout.service';
import {MainLayoutComponent} from './main-layout.component';
import {RouterModule, Routes} from '@angular/router';
import {DialogModule} from 'primeng/dialog';
import {LoginComponent} from '../login/login.component';

const routes:Routes =[
  {
    path:'login',
    component:LoginComponent
  }
];
@NgModule({
  imports: [
    RouterModule,
    CommonModule,
    FormsModule,
    DialogModule,
    ReactiveFormsModule
  ],
  providers: [MainLayoutService],
  declarations: [MainLayoutComponent]
})
export class MainLayoutModule {
}
