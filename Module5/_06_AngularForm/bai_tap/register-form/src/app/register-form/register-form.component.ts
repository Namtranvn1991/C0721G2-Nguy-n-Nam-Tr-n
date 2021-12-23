import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-register-form',
  templateUrl: './register-form.component.html',
  styleUrls: ['./register-form.component.css']
})
export class RegisterFormComponent implements OnInit {

  registerForm: FormGroup;
  countryList: string[] = ['VN', 'USA', 'JP'];

  errorMessages = {
    email: [
      { type: 'required', message: 'email is required.' },
      { type: 'email', message: 'Please enter a valid e-mail address!' }
    ],

    password: [
      { type: 'required', message: 'password is required.' },
      { type: 'minlength', message: 'password length min 6' }
    ],

    confirmPassword: [
      { type: 'required', message: 'password is required.' },
      { type: 'minlength', message: 'password length min 6' }
    ],

    age: [
      { type: 'required', message: 'age is required.' },
      { type: 'min', message: '+18' },
      { type: 'max', message: '+18' }
    ],
    phoneNumber: [
      { type: 'required', message: 'password is required.' },
      { type: 'pattern', message: 'Age must greater than 18 and lower 100!' }
    ],
  }


  constructor(private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.registerForm = this.formBuilder.group(
      {
        email: ['', [Validators.required, Validators.email]],
        password : ['', [Validators.required, Validators.minLength(6)]],
        confirmPassword: ['', [Validators.required, Validators.minLength(6)]],
        country: ['', [Validators.required]],
        age: ['', [Validators.required, Validators.min(18), Validators.max(100)]],
        gender: ['', [Validators.required]],
        phoneNumber: ['', [Validators.required, Validators.pattern('^\\+84\\d{9,10}$')]]
      }, {validators: this.passwordCheck.bind(this)}
    );
  }

  email(){
    return this.registerForm.get('email');
  }

  passwordCheck(formGroup: FormGroup) {
    const { value: password } = formGroup.get('password');
    const { value: confirmPassword } = formGroup.get('confirmPassword');
    return password === confirmPassword ? null : { passwordNotMatch: true };
  }

  onSubmit() {
    console.log(this.registerForm.value);
    console.log(this.registerForm.valid);
  }
}
