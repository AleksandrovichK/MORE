import {Component, OnInit} from '@angular/core';
import {InfoBarService} from '../components/info-bar/info-bar.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './main-layout.component.html'
})
export class MainLayoutComponent implements OnInit {
  constructor(private service: InfoBarService) {
  }

  ngOnInit() {
    let a = this.service.getPropertiesMap();
  }
}
