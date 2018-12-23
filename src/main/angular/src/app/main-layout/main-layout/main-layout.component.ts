import {Component, OnInit} from '@angular/core';
import {MainLayoutService} from '../main-layout.service';
import {FormBuilder, FormGroup} from '@angular/forms';

declare var ymaps: any;

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
  searchForm: FormGroup = this.builder.group({
      from: [null],
      to: [null],
      selectedCities: []
    }
  );

  constructor(private service: MainLayoutService, private builder: FormBuilder) {
  }

  ngOnInit() {
    ymaps.ready(this.initMap.bind(this));
  }

  onSubmit() {
    alert('SEARCHING');
  }

  initMap() {
    var map = new ymaps.Map('map', {
      center: [50.450100, 30.523400],
      zoom: 5
    });

    map.setType('yandex#hybrid');

    ymaps.geolocation.get({
      provider: 'browser',
      /*mapStateAutoApply: true*/
    }).then(function (result) {
      result.geoObjects.options.set('preset', 'islands#redDotIcon');
      map.geoObjects.add(result.geoObjects);
    });

    map.setZoom(5);
    map.cursors.push('crosshair');
    this.configureMapClicking(map);
  }

  private configureMapClicking(map) {
    var myPlacemark;
    map.events.add('click', function (e) {
      var coords = e.get('coords');

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

    var self = this;

    function getAddress(coords) {
      /*myPlacemark.properties.set('iconCaption', 'поиск...');*/
      ymaps.geocode(coords).then(function (res) {
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

        self.searchForm.patchValue({
          to: firstGeoObject.getLocalities(),
        });
      });
    }
  }
}
