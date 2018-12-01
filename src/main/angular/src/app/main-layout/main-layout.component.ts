import {Component, OnInit} from '@angular/core';
import {MainLayoutService} from './main-layout.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './main-layout.component.html'
})
export class MainLayoutComponent implements OnInit {
  properties = {
    tab1:' ',
    tab2:' ',
    tab3:' ',
    tab1_description:' ',
    tab2_description:' ',
    tab3_description:' ',
  };

  constructor(private service: MainLayoutService) {
  }

  ngOnInit() {
    this.service.getPropertiesMap().subscribe(
      res => {
        console.log(res);
        this.properties = res;
      }
    );
  }
}
