import { Router } from "@angular/router";
import { Component, OnInit } from "@angular/core";
import { MagazineService } from "src/app/services/magazine.service";
import { Magazine } from "src/app/model/magazine";
import { FormField } from "src/app/model/formField";
import { PaymentService } from "src/app/services/payment.service";
import { ActivatedRoute } from "@angular/router";

@Component({
  selector: "app-magazine-subscribe",
  templateUrl: "./magazine-subscribe.component.html",
  styleUrls: ["./magazine-subscribe.component.scss"]
})
export class MagazineSubscribeComponent implements OnInit {
  private formFields: FormField[] = [];
  magazineId;
  paymentsForMagazine;

  constructor(
    private magazineService: MagazineService,
    private paymentService: PaymentService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    this.magazineId = this.route.snapshot.params["magazineId"];
    this.magazineService.getAllPaymentTypes(this.magazineId).subscribe(res => {
      console.log(res);
      this.paymentsForMagazine = res;
    });
  }

  back() {
    this.router.navigate(["/magazine"]);
  }

  pay(paymentType: string) {
    this.router.navigate([
      "/magazine/" + this.magazineId + "/pay/" + paymentType
    ]);
  }
}
