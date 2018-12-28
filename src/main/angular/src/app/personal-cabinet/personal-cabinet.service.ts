import {Injectable} from '@angular/core';
import {DataClientService} from '../core/data-client.service';
import {Observable} from "rxjs";

@Injectable()
export class PersonalCabinetService {

  constructor(private dataClientService: DataClientService) {
  }
  getUSerById(UserID): Observable<any> {
    return this.dataClientService.get('/users/'+UserID);
  }
}
