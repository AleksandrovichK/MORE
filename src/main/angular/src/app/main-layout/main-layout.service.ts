import {Injectable} from '@angular/core';
import {DataClientService} from '../core/data-client.service';
import {Observable} from 'rxjs';
import {HttpParams} from "@angular/common/http";
import {ParamsHelper} from "../core/params-helper";

@Injectable()
export class MainLayoutService {

  constructor(private dataClientService: DataClientService) {
  }


  getPropertiesMap(): Observable<any> {
    return this.dataClientService.get('/ins/properties');
  }
  getPropertiById(PropertyID): Observable<any> {
    return this.dataClientService.get('/ins/properties');
  }
}
