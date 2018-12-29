import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Router} from '@angular/router';
import {PersonalCabinetService} from '../personal-cabinet.service';


@Component({
  selector: 'app-cab',
  templateUrl: './cab.component.html'
})
export class CabComponent implements OnInit {
  userForm: FormGroup = this.builder.group({
      id: [null],
      username: [null],
      password: [null],
      email: [null],
      balance: [null],
      registrationDate: [null],
      userTypeId: [null],
      isDeleted: [null]
    }
  );

  constructor(private builder: FormBuilder, private router: Router, private service: PersonalCabinetService) {
  }

  ngOnInit() {
    this.service
      .getUserById(1)
      .subscribe(data => {
        this.userForm.patchValue({
          id: data.id,
          username: data.username,
          password: data.password,
          email: data.email,
          balance: data.balance,
          registrationDate: data.registrationDate,
          userTypeId: data.userTypeId,
          isDeleted: data.isDeleted
        });
      });

  }

  onSubmit() {
    this.router.navigate(['']);

    /***
     * На сохранение формы - берёшь текущее её значение и отправляешь в сервис. Бэк замапит твой JSON на DTO-шку. По сути всё.*//*
    const formValue = {...this.userForm};
    this.service.setUser(formValue);*/
  }
}
