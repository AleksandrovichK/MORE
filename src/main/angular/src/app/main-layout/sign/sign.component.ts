import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Router} from '@angular/router';
import {PasswordModule} from 'primeng/password';

// @ts-ignore
@Component({
  selector: 'app-login',
  templateUrl: './sign.component.html'
})
export class SignComponent implements OnInit {
  user$:Object;
  loginForm: FormGroup = this.builder.group({
      login: [null],
      password: [null],
      email: [null]
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
