import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Router} from '@angular/router';
import {PasswordModule} from 'primeng/password';

@Component({
  selector: 'app-login',
  templateUrl: './registration.component.html'
})
export class RegistrationComponent implements OnInit {

  registrationForm: FormGroup = this.builder.group({
      login: [null],
      password: [null],
      email: [null],
      name: [null],
      home: [null],
      birthday: [null]
    }
  );

  constructor(private builder: FormBuilder, private router: Router) {

  }

  ngOnInit() {
  }

  onSubmit() {
    this.router.navigate(['']);
  }
}
