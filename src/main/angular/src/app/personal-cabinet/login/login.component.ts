import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Router} from '@angular/router';
import {PersonalCabinetService} from "../personal-cabinet.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html'
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup = this.builder.group({
      username: [''],
      password: [''],
    }
  );
  wrongCredentials = false;

  constructor(private builder: FormBuilder, private router: Router, private service: PersonalCabinetService) {
  }

  ngOnInit() {
  }

  onSubmit() {
    this.service
      .signIn(this.loginForm.getRawValue())
      .subscribe((authAnswer) => {
        if (authAnswer !== null) {
          console.log(authAnswer);
          localStorage.setItem('currentUser', JSON.stringify(authAnswer.username));
          localStorage.setItem('currentToken', JSON.stringify(authAnswer.token));
          this.router.navigate(['/cab/'+authAnswer.username]);
          this.wrongCredentials = false;
        } else {
          this.wrongCredentials = true;
        }
      });
  }
}
