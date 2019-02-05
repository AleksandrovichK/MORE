import {Injectable} from '@angular/core';
import {DataClientService} from '../core/data-client.service';
import {User} from '../core/models/user';
import {Observable} from 'rxjs';
import {HttpParams} from "@angular/common/http";
import {ParamsHelper} from "../core/params-helper";

@Injectable()
export class PersonalCabinetService {

  constructor(private dataClientService: DataClientService) {
  }

  getUserByLogin(login: string){
   const params: HttpParams = ParamsHelper.toHttpParams({
     login: login
   });
   return this.dataClientService.get('/users/credentials', params);
 }

  createUser(user): Observable<User> {
    return this.dataClientService.post('/authentication/sign-up', user);
  }

  updateUser(user): Observable<User> {
    return this.dataClientService.post('/users/', user);
  }

  signIn(formValue): Observable<any> {
    return this.dataClientService.post('/authentication/sign-in', formValue)
  }
}

