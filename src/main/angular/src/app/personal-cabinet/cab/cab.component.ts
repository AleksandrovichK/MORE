import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {PersonalCabinetService} from '../personal-cabinet.service';
import {computeStyle} from "@angular/animations/browser/src/util";


@Component({
  selector: 'app-cab',
  templateUrl: './cab.component.html'
})
export class CabComponent implements OnInit {
  userForm: FormGroup = this.builder.group({
      id: [null],
      login: [null],
      password: [null],
      fullname: [null],
      role: [null],
      registrationDate: [null],
      travelsCount: [null]
    });

  disabled = true;

  constructor(private router: Router,
              private builder: FormBuilder,
              private route: ActivatedRoute,
              private service: PersonalCabinetService) {
  }

  ngOnInit() {
    const data = this.route.snapshot.params;
    const login = data.login;
    console.log('login in cab is:', login);

    if (login != null) {
      this.service
        .getUserByLogin(login)
        .subscribe(data => {
          console.log('user data:', data);
          this.userForm.patchValue({
            id: data.id,
            login: data.login,
            password: data.login,
            fullname: data.fullname,
            role: data.role,
            registrationDate: new Date(data.registrationDate),
            travelsCount: data.travelsCount
          });
        });
    }
  }

  onSubmit() {
    console.log('form value is', this.userForm.getRawValue());
    this.service
      .updateUser(this.userForm.getRawValue())
      .subscribe();
  }
}
