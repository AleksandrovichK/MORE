import {Injectable} from '@angular/core';
import {DataClientService} from '../core/data-client.service';
import {User} from './cab/models/user';
import {Observable} from 'rxjs';

@Injectable()
export class PersonalCabinetService {

  constructor(private dataClientService: DataClientService) {
  }

  getUserById(UserID): Observable<User> {
    return this.dataClientService.get('/users/' + UserID);
  }

  saveUser(user: Observable<User>): Observable<User> {
    this.dataClientService.post('/users/', user);
  }
}

