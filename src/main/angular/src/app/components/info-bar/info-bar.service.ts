import { Injectable } from '@angular/core';
import {DataClientService} from '../../core/data-client.service';

@Injectable()
export class InfoBarService {

  constructor(private dataClientService: DataClientService) {
  }

  getPropertiesMap(): Map<string, any> {
    const res = this.dataClientService.get('/ins/properties').subscribe(
      res => console.log(res)
    );
    return new Map<string, any>();
  }
}
