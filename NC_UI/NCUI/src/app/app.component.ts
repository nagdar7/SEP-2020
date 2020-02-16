import { Editor } from "./guard/editor.guard";
import { Authorized } from "./guard/authorized.guard";
import { UserService } from "./services/user.service";
import { Component } from "@angular/core";
import { Router } from "@angular/router";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.scss"]
})
export class AppComponent {
  title = "NCUI";

  constructor(
    private userService: UserService,
    private authorized: Authorized,
    private editor: Editor,
    private router: Router
  ) {}

  public isEditor() {
    return this.editor.canActivate();
  }

  public loggedIn() {
    if (this.authorized.canActivate()) {
      return true;
    } else {
      return false;
    }
  }

  public logout() {
    this.userService.logout();
    this.router.navigate(["/"]);
  }
}
