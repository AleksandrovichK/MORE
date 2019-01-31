import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Router} from '@angular/router';
import {PersonalCabinetService} from "../personal-cabinet.service";

@Component({
  selector: 'app-login',
  templateUrl: './registration.component.html'
})
export class RegistrationComponent implements OnInit {
  text: string;
  results: string[];

  registrationForm: FormGroup = this.builder.group({
      username: [''],
      password: [''],
      email: [''],
      balance: ['0'],
      registrationDate: [new Date()],
      userTypeId: [''],
      isDeleted: [null]
    }
  );
  private mylookupservice: any;

  constructor(private builder: FormBuilder, private router: Router, private service: PersonalCabinetService) {

  }
  search(event) {
    this.mylookupservice.getResults(event.query).then(data => {
      this.results = data;
    });
  }

  ngOnInit() {
  }

  onSubmit() {
    console.log(this.registrationForm.getRawValue().username);
   this.service.getUserByUsername(this.registrationForm.getRawValue().username)
      .subscribe(data => {
        console.log(data);

        if (data !== null) {
          console.log('Такой уже существует');
        }
        else {
          this.service
            .createUser(this.registrationForm.getRawValue())
            .subscribe();
          this.router.navigate(['../../']);
        }
      });
  }
}

