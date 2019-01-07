import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Router} from '@angular/router';
import {PasswordModule} from 'primeng/password';
import {PersonalCabinetService} from "../personal-cabinet.service";

@Component({
  selector: 'app-login',
  templateUrl: './registration.component.html'
})
export class RegistrationComponent implements OnInit {

  registrationForm: FormGroup = this.builder.group({
    id: [],
    username: [''],
    password: [''],
    email: [''],
    balance: ['0'],
    registrationDate: [new Date()],
    userTypeId: [''],
    isDeleted: [null]
    }
  );

  constructor(private builder: FormBuilder, private router: Router, private service: PersonalCabinetService) {

  }

  ngOnInit() {
  }

  onSubmit() {
    console.log(this.registrationForm.getRawValue());
    this.service
      .saveUser(this.registrationForm.getRawValue())
      .subscribe(res => console.log('Object\'s ID:', res));
  }
}
