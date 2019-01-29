import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Router} from '@angular/router';
import {PersonalCabinetService} from "../personal-cabinet.service";

@Component({
  selector: 'app-login',
  templateUrl: './registration.component.html'
})
export class RegistrationComponent implements OnInit {
  result: boolean;

  text: string;

  results: string[];

  registrationForm: FormGroup = this.builder.group({
      id: [],
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
    //console.log(this.result);
  }

  onSubmit() {

   this.service.checkEmail(this.registrationForm.getRawValue())
      .subscribe(data => this.result = data);
    if (this.result === true) {
      console.log("User with this email already exists");
    }/* else {
      this.service
        .saveUser(this.registrationForm.getRawValue())
        .subscribe(res => console.log('Object\'s ID:', res));
      this.router.navigate(['login/registration/cab']);
    }*/
  }
}

