import { Component, OnInit } from '@angular/core';
import {InfoBarService} from './info-bar.service';

@Component({
  selector: 'app-info-bar',
  templateUrl: './info-bar.component.html',
  styleUrls: ['./info-bar.component.css']
})
export class InfoBarComponent implements OnInit {
  properties: Map <string, any>;

  constructor() { }

  ngOnInit() {

  }

}
