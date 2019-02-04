import {Injectable} from '@angular/core';
import {DataClientService} from '../core/data-client.service';
import {Observable} from 'rxjs';

@Injectable()
export class MainLayoutService {

  constructor(private dataClientService: DataClientService) {
  }


  getPropertiesMap(): Observable<any> {
    return this.dataClientService.get('/ins/properties');
  }
}
