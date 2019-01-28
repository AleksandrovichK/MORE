import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppRoutingModule} from './app.routing';
import {RouterModule} from '@angular/router';
import {MainLayoutModule} from './main-layout/main-layout.module';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {AppComponent} from './app.component';
import {ReactiveFormsModule} from '@angular/forms';
import {PersonalCabinetModule} from './personal-cabinet/personal-cabinet.module';
import {ErrorInterceptor} from "./core/error.interceptor";
import {BasicAuthInterceptor} from "./core/basic-auth.interceptor";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    RouterModule,
    AppRoutingModule,
    MainLayoutModule,
    PersonalCabinetModule,
    HttpClientModule,
    BrowserAnimationsModule,
    ReactiveFormsModule
  ],
  providers: [
    {provide: HTTP_INTERCEPTORS, useClass: BasicAuthInterceptor, multi: true},
    {provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true}],

  bootstrap: [AppComponent]
})
export class AppModule {
}
