import {CommonModule} from '@angular/common';
import {NgModule} from '@angular/core';

import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MainLayoutService} from './main-layout.service';
import {MainLayoutComponent} from './main-layout/main-layout.component';
import {RouterModule} from '@angular/router';
import {DialogModule} from 'primeng/dialog';
import {LoginComponent} from './login/login.component';
import {MainLayoutRoutingModule} from './main-layout.routing';
import  {SignComponent} from './sign/sign.component';

@NgModule({
  imports: [
    RouterModule,
    MainLayoutRoutingModule,
    CommonModule,
    FormsModule,
    DialogModule,
    ReactiveFormsModule
  ],
  providers: [MainLayoutService],
  declarations: [MainLayoutComponent, LoginComponent, SignComponent]
})
export class MainLayoutModule {
}
