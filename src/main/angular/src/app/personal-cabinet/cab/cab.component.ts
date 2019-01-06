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
      id: [0],
      username: [''],
      password: [''],
      email: [''],
      balance: [''],
      registrationDate: [new Date()],
      userTypeId: [''],
      isDeleted: [null]
    }
  );

  constructor(private builder: FormBuilder, private router: Router, private service: PersonalCabinetService) {
  }

  ngOnInit() {
    this.service
      .getUserById(1)
      .subscribe(data => {
        console.log(data);

        this.userForm.patchValue({
          id: data.id,
          username: data.username,
          password: data.password,
          email: data.email,
          balance: data.balance,
          registrationDate: new Date(data.registrationDate),
          userTypeId: data.userTypeId,
          isDeleted: data.isDeleted
        });
      });
  }

  onSubmit() {
    console.log(this.userForm.getRawValue())
    this.service.saveUser(this.userForm.getRawValue());
    /*this.router.navigate(['']);*/
  }
}
