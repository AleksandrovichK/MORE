import { Injectable } from '@angular/core';
import {DataClientService} from '../../core/data-client.service';

@Injectable()
export class AuthorBarService {
  constructor(service: DataClientService) {
  }
}
