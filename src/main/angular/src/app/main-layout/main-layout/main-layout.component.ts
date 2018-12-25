import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';

import { MainLayoutService } from '../main-layout.service';

declare const ymaps: any;

@Component({
  selector: 'app-dashboard',
  templateUrl: './main-layout.component.html'
})
export class MainLayoutComponent implements OnInit {
  properties: object;
  travelWays = [
    {label: 'Самолётом', value: {id: 1}},
    {label: 'Поездом', value: {id: 2}},
    {label: 'Автостопом', value: {id: 3}},
    {label: 'Машиной', value: {id: 4}},
    {label: 'Пешком', value: {id: 5}}
  ];
  info: string;
  listFrom: string[] = [];
  listTo: string[] = [];

  loadingFrom = false;
  loadingTo = false;

  searchForm: FormGroup = this.builder.group({
      from: [null],
      to: [null],
      selectedCities: []
    }
  );

  constructor(private service: MainLayoutService, private builder: FormBuilder) {}

  ngOnInit() {
    ymaps.ready(this.initMap.bind(this));
  }

  public async searchFrom(query) {
    if (query.length <= 2) {
      return;
    }

    this.loadingFrom = true;
    const map = await ymaps.geocode(query, { results: 5 });
    this.loadingFrom = false;

    this.listFrom = [];

    map.geoObjects.each((city) => {
      if (city.properties.get('metaDataProperty.GeocoderMetaData.kind') === 'locality') {
        this.listFrom.push(city.properties.get('name'));
      }
    });
  }

  public async searchTo(query) {
    if (query.length <= 2) {
      return;
    }

    this.loadingTo = true;
    const map = await ymaps.geocode(query, { results: 5 });
    this.loadingTo = false;

    this.listTo = [];

    map.geoObjects.each((city) => {
      if (city.properties.get('metaDataProperty.GeocoderMetaData.kind') === 'locality') {
        this.listTo.push(city.properties.get('name'));
      }
    });

    console.log(this.listTo);
  }

  public selectFrom(suggestion) {
    this.listFrom = [];
    console.log(suggestion);
  }

  public selectTo(suggestion) {
    this.listTo = [];
    console.log(suggestion);
  }

  onSubmit() {
  }

  initMap() {
    var map = new ymaps.Map('map', {
      center: [50.450100, 30.523400],
      zoom: 5
    });

    map.setType('yandex#hybrid');

    ymaps.geolocation.get({
      provider: 'browser',
    }).then((result) => {
      result.geoObjects.options.set('preset', 'islands#redDotIcon');
      map.geoObjects.add(result.geoObjects);
    });

    map.setZoom(5);
    map.cursors.push('crosshair');
    this.configureMapClicking(map);
  }

  private configureMapClicking(map) {
    let myPlacemark;
    map.events.add('click', (e) => {
      const coords = e.get('coords');

      if (myPlacemark) {
        myPlacemark.geometry.setCoordinates(coords);
      }
      else {
        myPlacemark = createPlacemark(coords);
        map.geoObjects.add(myPlacemark);
        myPlacemark.events.add('dragend', function () {
          getAddress(myPlacemark.geometry.getCoordinates());
        });
      }
      map.setCenter(ymaps.geoQuery(coords).getCenter());
      getAddress(coords);
    });


    function createPlacemark(coords) {
      return new ymaps.Placemark(coords, {
        iconCaption: ''
      }, {
        preset: 'islands#blueDotIcon',
        draggable: true
      });
    }

    function getAddress(coords) {
      ymaps.geocode(coords).then((res) => {
        var firstGeoObject = res.geoObjects.get(0);

        /*   myPlacemark.properties.set({
             // Формируем строку с данными об объекте.
             iconCaption: [
               // Название населенного пункта или вышестоящее административно-территориальное образование.
               firstGeoObject.getLocalities().length ? firstGeoObject.getLocalities() : firstGeoObject.getAdministrativeAreas()/!*,
               // Получаем путь до топонима, если метод вернул null, запрашиваем наименование здания.
               firstGeoObject.getThoroughfare() || firstGeoObject.getPremise()*!/
             ].filter(Boolean).join(', '),
             // В качестве контента балуна задаем строку с адресом объекта.
             balloonContent: firstGeoObject.getAddressLine()
           });*/

        this.searchForm.patchValue({
          to: firstGeoObject.getLocalities(),
        });
      });
    }
  }
}
