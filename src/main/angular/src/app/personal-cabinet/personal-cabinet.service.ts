import {Injectable} from '@angular/core';
import {DataClientService} from '../core/data-client.service';
import {User} from './cab/models/user';
import {Observable} from 'rxjs';
import { of } from 'rxjs';

@Injectable()
export class PersonalCabinetService {

  constructor(private dataClientService: DataClientService) {
  }

  /**
  У меня не работает база, соответственно бэк, соответственно не могу протестить. Скорее всего так всё будет работать.
  Раскомменти этот метод - он притянет с бэка информацию. Метод ниже удали или закомменти, это тупо шаблон чтобы убедиться, что всё работает*//*
  getUserById(UserID): Observable<User> {
    return this.dataClientService.get('/users/' + UserID);
  }*/

  getUserById(UserID): Observable<User> {
    return of(new User(1, 'Евгений Дубинцов', 'HelenHarper', 'shurupe@tam.by', new Date(), 200.34, 2, false));
  }
}
