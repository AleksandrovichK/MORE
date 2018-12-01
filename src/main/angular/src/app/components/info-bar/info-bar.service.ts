import { Injectable } from '@angular/core';
import {DataClientService} from '../../core/data-client.service';

@Injectable()
export class InfoBarService {
  constructor(service: DataClientService) {
  }
}
