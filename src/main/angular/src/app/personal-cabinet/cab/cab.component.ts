import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Router} from '@angular/router';
import {PersonalCabinetService} from "../personal-cabinet.service";
import {Observable} from "rxjs";
import {DataClientService} from "../../core/data-client.service";


@Component({
  selector: 'app-cab',
  templateUrl: './cab.component.html'
})
export class CabComponent implements OnInit {
  user: Object;

  loginForm: FormGroup = this.builder.group({
      login: [null],
      password: [null]
    }
  );

  constructor(private builder: FormBuilder, private router: Router, private data:DataClientService) { }

  ngOnInit() {
    this.data.get('/users/1').subscribe(
      data=>this.user = data
    )

  }

  onSubmit() {
    this.router.navigate(['']);
  }
}
export class ModelComponent {

  value: boolean;

}
