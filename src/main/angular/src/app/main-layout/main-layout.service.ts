import { Injectable } from '@angular/core';
import {DataClientService} from '../core/data-client.service';

@Injectable()
export class MainLayoutService {

  constructor(private dataClientService: DataClientService) {
  }

  getPropertiesMap(): Map<string, any> {
    this.dataClientService.get('/ins/properties').subscribe(
      res => console.log('results', res )
    );

    return new Map<string, any>();
  }
}
