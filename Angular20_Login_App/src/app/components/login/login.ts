import { Component, inject } from '@angular/core';
import { NonNullableFormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { LoginService } from '../../services/login-service';
import { LoginRequest } from '../../interfaces/LoginRequest';
import { UserRegistration } from '../../interfaces/UserRegistration';
import { ApiResponse } from '../../interfaces/ApiResponse';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  imports: [ReactiveFormsModule],
  templateUrl: './login.html',
  styleUrl: './login.css',
})
export class Login {

  isLogin = true;

  private fb = inject(NonNullableFormBuilder);
  private loginService = inject(LoginService);
  private router = inject(Router);
  response! : ApiResponse;


  loginForm = this.fb.group({
    userName: ['', Validators.required],
    password: ['', Validators.required]
  });

  registerForm = this.fb.group({
    userName: ['', [Validators.required, Validators.minLength(3)]],
    email: ['', [Validators.required, Validators.email]],
    password: ['', [Validators.required, Validators.minLength(6)]],
    contactNo: ['', [Validators.required, Validators.minLength(10)]]
  });

  toggleForm() {
    this.isLogin = !this.isLogin;
  }

  submitLogin() {
    if (this.loginForm.valid) {
      const loginRequest: LoginRequest = this.loginForm.getRawValue();
      this.loginService.login(loginRequest).subscribe({
        next: (res) => {
          if (res.status == "SUCCESS") {
            localStorage.setItem("JSESSIONID", res.message);
            this.router.navigate(["/dashboard"]);
          }
        }, error: (error) => {
          alert(error.error.message)
        }
      });
    }
    this.loginForm.markAllAsTouched();
  }

  submitRegister() {
    if (this.registerForm.valid) {
      const userDetails: UserRegistration = this.registerForm.getRawValue();
      this.loginService.userRegister(userDetails).subscribe({
        next: (res) => {
           alert(res)
        }, error: (error) => {
           alert(error.error.message)
        }
      })
    }
    this.registerForm.markAllAsTouched();
  }

}