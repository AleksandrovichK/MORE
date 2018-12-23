import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Router} from '@angular/router';


@Component({
  selector: 'app-cab',
  templateUrl: './cab.component.html'
})
export class CabComponent implements OnInit {

  loginForm: FormGroup = this.builder.group({
      login: [null],
      password: [null]
    }
  );

  constructor(private builder: FormBuilder, private router: Router) { }

  ngOnInit() {
  }

  onSubmit() {
    this.router.navigate(['']);
  }
}
export class ModelComponent {

  value: boolean;

}
