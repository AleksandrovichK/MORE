import {CommonModule} from '@angular/common';
import {NgModule} from '@angular/core';

import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MainLayoutService} from './main-layout.service';
import {MainLayoutComponent} from './main-layout/main-layout.component';
import {RouterModule} from '@angular/router';
import {MainLayoutRoutingModule} from './main-layout.routing';
import {MultiSelectModule} from 'primeng/multiselect';
import {RadioButtonModule} from 'primeng/radiobutton';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {AutocompleteComponent} from './autocomplete/autocomplete.component';

@NgModule({
  imports: [
    RouterModule,
    MainLayoutRoutingModule,
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MultiSelectModule,
    RadioButtonModule
  ],
  providers: [MainLayoutService],
  declarations: [MainLayoutComponent, AutocompleteComponent]
})
export class MainLayoutModule {
}
