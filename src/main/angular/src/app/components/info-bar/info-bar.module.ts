import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {InfoBarComponent} from './info-bar.component';
import {InfoBarService} from './info-bar.service';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [InfoBarService],
  declarations: [InfoBarComponent]
})
export class InfoBarModule { }
