import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';

import {MainLayoutService} from '../main-layout.service';
import {Router} from "@angular/router";

declare const ymaps: any;

@Component({
  selector: 'app-dashboard',
  templateUrl: './main-layout.component.html'
})
export class MainLayoutComponent implements OnInit {
  map: any = null;

  properties: object;
  travelWays = [
    {label: 'Самолётом', value: {id: 1}},
    {label: 'Поездом', value: {id: 2}},
    {label: 'Автостопом', value: {id: 3}},
    {label: 'Машиной', value: {id: 4}},
    {label: 'Пешком', value: {id: 5}}
  ];

  info: string;
  user: string = null;

  listFrom: string[] = [];
  listTo: string[] = [];

  loadingFrom = false;
  loadingTo = false;

  pointFrom : any;
  pointTo : any;

  country: string;

  searchForm: FormGroup = this.builder.group({
      fromС: [null],
      toC: [null],
      selectedCities: []
    }
  );


  constructor(private service: MainLayoutService, private builder: FormBuilder, private router: Router) {
  }

  ngOnInit() {
    if (localStorage.getItem('currentUser')) {
      let userName = localStorage.getItem('currentUser');
      userName = userName.replace(/"/g, "");
      this.user = userName;
    }
    ymaps.ready(this.initMap.bind(this));
  }

  initMap() {
    this.map = new ymaps.Map('map', {
      center: [50.450100, 30.523400],
      zoom: 1,
      controls: []
    });

    this.map.setType('yandex#hybrid');
    this.map.setZoom(5);
    this.map.cursors.push('crosshair');
  }

  onSubmit() {
    //alert('Wroom-wroom!');

    console.log(this.listTo);
  }

  public async searchFrom(query) {
    if (query.length <= 2) {
      return;
    }

    this.loadingFrom = true;
    let container = await ymaps.geocode(query, {results: 5});
    this.loadingFrom = false;

    this.listFrom = [];
    container.geoObjects.each((city) => {
      if (city.properties.get('metaDataProperty.GeocoderMetaData.kind') === 'locality') {
        this.listFrom.push(city.properties.get('text'));
        //this.listFrom.push(city.properties.get('name'));
      }
    });
  }

  public async searchTo(query) {
    if (query.length <= 2) {
      return;
    }

    this.loadingTo = true;
    let container = await ymaps.geocode(query, {results: 5});
    this.loadingTo = false;

    this.listTo = [];

    container.geoObjects.each((city) => {
      if (city.properties.get('metaDataProperty.GeocoderMetaData.kind') === 'locality') {
        this.listTo.push(city.properties.get('text'));
      }
    });
  }

  public selectFrom(suggestion) {
    this.listFrom = [];

    ymaps.geocode(suggestion, {
      results: 1
    }).then((res) => {
      this.pointFrom = res.geoObjects.get(0);
      this.pointFrom.options.set('preset', 'islands#circleIcon');
      this.pointFrom.options.set('iconColor', '#a61c21');
      this.pointFrom.properties.set('iconCaption', this.pointFrom.getAddressLine());

      this.map.geoObjects.removeAll();
      this.map.geoObjects.add(this.pointFrom);
      this.map.geoObjects.add(this.pointTo);
    });
  }

  public selectTo(suggestion) {
    this.listTo = [];

    ymaps.geocode(suggestion, {
      results: 1
    }).then((res) => {
      this.pointTo = res.geoObjects.get(0);
      this.pointTo.options.set('preset', 'islands#circleIcon');
      this.pointTo.options.set('iconColor', '#0d24a6');
      this.pointTo.properties.set('iconCaption', this.pointTo.getAddressLine());

      this.map.geoObjects.removeAll();
      this.map.geoObjects.add(this.pointTo);
      this.map.geoObjects.add(this.pointFrom);
    });
  }

  routeToCabinet() {
    this.router.navigate(['cab/' + this.user]);
  }

  logout() {
    localStorage.removeItem('currentUser');
    localStorage.removeItem('currentToken');
    location.reload();
  }
}
