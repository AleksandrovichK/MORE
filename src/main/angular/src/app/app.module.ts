import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppComponent} from './app.component';
import {InfoBarModule} from './components/info-bar/info-bar.module';
import {AppRoutingModule} from './app.routing';
import {RouterModule} from '@angular/router';
import {AuthorBarModule} from './components/author-bar/author-bar.module';
import {MainLayoutModule} from './main-layout/main-layout.module';
import {HttpClientModule} from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    RouterModule,
    AppRoutingModule,
    MainLayoutModule,
    InfoBarModule,
    AuthorBarModule,
    BrowserModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
