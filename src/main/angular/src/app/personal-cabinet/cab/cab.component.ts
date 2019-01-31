import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {PersonalCabinetService} from '../personal-cabinet.service';


@Component({
  selector: 'app-cab',
  templateUrl: './cab.component.html'
})
export class CabComponent implements OnInit {
  username: string = null;
  userForm: FormGroup = this.builder.group({
      id: [null],
      username: [''],
      password: [''],
      email: [''],
      balance: [''],
      registrationDate: [new Date()],
      userTypeId: [''],
      isDeleted: [null]
    });

  constructor(private builder: FormBuilder, private router: Router, private service: PersonalCabinetService,  private route: ActivatedRoute) {
  }

  ngOnInit() {
    const data = this.route.snapshot.params;
    this.username = data.username;
    console.log('username in cab is:', this.username);

    if (this.username != null) {
      this.service
        .getUserByUsername(this.username)
        .subscribe(data => {
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

  }

  onSubmit() {
    this.service
      .updateUser(this.userForm.getRawValue())
      .subscribe();
    location.reload();
  }
}
