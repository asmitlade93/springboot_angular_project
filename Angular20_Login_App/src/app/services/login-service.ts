import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { LoginRequest } from '../interfaces/LoginRequest';
import { UserRegistration } from '../interfaces/UserRegistration';
import { Observable } from 'rxjs';
import { ApiResponse } from '../interfaces/ApiResponse';

@Injectable({
  providedIn: 'root',
})
export class LoginService {

  endpointURL: string = "/api";

  http = inject(HttpClient);

  login(login: LoginRequest): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.endpointURL + "/auth/login", login);
  }

  userRegister(userDetails: UserRegistration) {
    return this.http.post(this.endpointURL + "/auth/register", userDetails);
  }
}
