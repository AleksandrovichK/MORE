import {Component, OnInit} from '@angular/core';
import {MainLayoutService} from '../main-layout.service';

declare var ymaps:any;

@Component({
  selector: 'app-dashboard',
  templateUrl: './main-layout.component.html'
})

export class MainLayoutComponent implements OnInit {
  properties: object;
  public map :any;

  constructor(private service: MainLayoutService) {
  }

  ngOnInit() {
    ymaps.ready(this.initMap.bind(this));
  }

  initMap() {
  this.map = new ymaps.Map('map', {
    center: [50.450100, 30.523400],
    zoom: 6
  });

}}
