import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Router} from '@angular/router';
import {PersonalCabinetService} from "../personal-cabinet.service";

@Component({
  selector: 'app-login',
  templateUrl: './registration.component.html'
})
export class RegistrationComponent implements OnInit {
  userExists = false;

  registrationForm: FormGroup = this.builder.group({
      login: [''],
      password: [''],
      fullname: [''],
    }
  );

  constructor(private builder: FormBuilder, private router: Router, private service: PersonalCabinetService) {

  }

  ngOnInit() {
  }

  onSubmit() {
    console.log(this.registrationForm.getRawValue());

    this.service
      .createUser(this.registrationForm.getRawValue())
      .subscribe((answer) => {
        console.log(answer);
        if (answer !== null) {
          this.service
            .signIn({login: this.registrationForm.getRawValue().login, password: this.registrationForm.getRawValue().password})
            .subscribe((authAnswer) => {
              if (authAnswer !== null) {
                localStorage.setItem('currentUser', JSON.stringify(authAnswer.login));
                localStorage.setItem('currentToken', JSON.stringify(authAnswer.token));
                this.router.navigate(['../../']);
                this.userExists = false;
              }
            });
        } else {
          this.userExists = true;
        }
      });


  }
}

