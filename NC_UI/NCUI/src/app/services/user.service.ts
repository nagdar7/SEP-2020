import { Injectable } from "@angular/core";

import { HttpClient, HttpHeaders } from "@angular/common/http";

import { Observable } from "rxjs";

import { HOST_URL } from "../../config";
import { map } from "rxjs/operators";

@Injectable({
  providedIn: "root"
})
export class UserService {
  constructor(private http: HttpClient) {}

  registerUser(user) {
    return this.http.post(
      HOST_URL + "/api/user/registration",
      user
    ) as Observable<any>;
  }

  loginUser(user) {
    return this.http.post(HOST_URL + "/api/user/login/", user).pipe(
      map((res: any) => {
        localStorage.setItem("jwt-token", res.value);
        const user = this.parseJwt(res.value);
        localStorage.setItem("user", user);
        localStorage.setItem("roles", user.roles);
        return user;
      })
    ) as Observable<any>;
  }

  logout() {
    localStorage.removeItem("jwt-token");
    localStorage.removeItem("user");
    localStorage.removeItem("roles");
  }

  private parseJwt(token) {
    var base64Url = token.split(".")[1];
    var base64 = base64Url.replace(/-/g, "+").replace(/_/g, "/");
    var jsonPayload = decodeURIComponent(
      atob(base64)
        .split("")
        .map(function(c) {
          return "%" + ("00" + c.charCodeAt(0).toString(16)).slice(-2);
        })
        .join("")
    );

    return JSON.parse(jsonPayload);
  }
}
