import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Router} from '@angular/router';
import {PersonalCabinetService} from "../personal-cabinet.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html'
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup = this.builder.group({
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
  result: boolean;

  constructor(private builder: FormBuilder, private router: Router,private service:PersonalCabinetService) { }

  ngOnInit() {
  }

  onSubmit() {
    /*const formValue = this.loginForm.value;
    this.router.navigate(['']);*/
    this.service.checkEmail(this.loginForm.getRawValue())
      .subscribe(data=>this.result = data);
    if(this.result === true){
      this.router.navigate(['']);
    }
    else{
     this.loginForm = this.builder.group({
         id: [],
         username: [''],
         password: ['wrong'],
         email: ['wrong'],
         balance: ['0'],
         registrationDate: [new Date()],
         userTypeId: [''],
         isDeleted: [null]
       }
     );
    }
  }
}
