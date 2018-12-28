import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html'
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup = this.builder.group({
      login: [null],
      password: [null]
    }
  );

  constructor(private builder: FormBuilder, private router: Router) { }

  ngOnInit() {
  }

  onSubmit() {
    const formValue = this.loginForm.value;

    this.router.navigate(['']);
  }
}
