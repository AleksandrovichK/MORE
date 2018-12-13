import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {MainLayoutComponent} from './main-layout/main-layout.component';
import {LoginModule} from './login/login.module';

export const routes: Routes = [
  {

    path: '',
    component: MainLayoutComponent,
    data: {
      title: 'Главная',
      pageId: 1
    },
    children: [
      {
        path: '/tohere1',
        component: LoginModule
      }]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
