import { Login } from "./../../model/login";
import { UserService } from "./../../services/user.service";
import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";

// import { JwtHelperService } from '@auth0/angular-jwt';

@Component({
  selector: "app-login",
  templateUrl: "./login.component.html",
  styleUrls: ["./login.component.scss"]
})
export class LoginComponent implements OnInit {
  login: Login;

  constructor(private userService: UserService, private router: Router) {}

  ngOnInit() {
    this.login = new Login();
  }

  save() {
    this.userService.loginUser(this.login).subscribe(x => {
      console.log(x);
      this.router.navigate(["/"]);
    });
  }
}
