import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Router} from '@angular/router';
import {PasswordModule} from 'primeng/password';
import {PersonalCabinetService} from "../personal-cabinet.service";
import {User} from "./models/user";
import {el} from "@angular/platform-browser/testing/src/browser_util";

@Component({
  selector: 'app-login',
  templateUrl: './registration.component.html'
})
export class RegistrationComponent implements OnInit {
  result:boolean;
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
    //console.log(this.result);
  }

  onSubmit() {

    this.service.checkEmail(this.registrationForm.getRawValue())
      .subscribe(data=>this.result = data);
    if(this.result === true){
      console.log("User with this email already exists");
    }
    else{
      this.service
        .saveUser(this.registrationForm.getRawValue())
        .subscribe(res => console.log('Object\'s ID:', res));
      this.router.navigate(['login/registration/cab']);
    }

  }
}
