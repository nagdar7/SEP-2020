import { UserService } from "./../../services/user.service";
import { Register } from "./../../model/register";
import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";

@Component({
  selector: "app-registration",
  templateUrl: "./registration.component.html",
  styleUrls: ["./registration.component.scss"]
})
export class RegistrationComponent implements OnInit {
  register: Register;

  constructor(private userService: UserService, private router: Router) {}

  ngOnInit() {
    this.register = new Register();
  }

  save() {
    this.userService.registerUser(this.register).subscribe(x => {
      console.log(x);
      this.router.navigate(["/"]);
    });
  }
}
