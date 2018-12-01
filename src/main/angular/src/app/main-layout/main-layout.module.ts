import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {MainLayoutService} from './main-layout.service';
import {MainLayoutComponent} from './main-layout.component';
import {RouterModule} from '@angular/router';
import {DialogModule} from 'primeng/dialog';

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
export class MainLayoutModule { }