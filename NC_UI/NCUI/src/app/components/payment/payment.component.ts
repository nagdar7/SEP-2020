import { CLIENT_URL } from "./../../../config";
import { Component, OnInit, Input, ChangeDetectorRef } from "@angular/core";
import { FormField } from "src/app/model/formField";
import { OnDestroy } from "@angular/core/src/metadata/lifecycle_hooks";
import { Subscription } from "rxjs/internal/Subscription";
import { PaymentService } from "src/app/services/payment.service";
import { Template } from "src/app/model/template";
import { MagazineService } from "src/app/services/magazine.service";
import { ActivatedRoute, Router } from "@angular/router";

@Component({
  selector: "app-payment",
  templateUrl: "./payment.component.html",
  styleUrls: ["./payment.component.scss"]
})
export class PaymentComponent implements OnInit {
  @Input("instance") instance: string;

  // private subscriptions: Subscription = new Subscription();

  private formFields: FormField[];
  private templates: Template[] = [];
  private dataAvailable: boolean = false;
  private response: any[] = [];
  magazineId;
  paymentType;

  constructor(
    private paymentService: PaymentService,
    private magazineService: MagazineService,
    private cdRef: ChangeDetectorRef,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit() {
    this.magazineId = this.route.snapshot.params["magazineId"];
    this.paymentType = this.route.snapshot.params["paymentType"];
    this.magazineService.paymentUI(this.paymentType).subscribe(res => {
      // console.log(res);
      this.formFields = res;
      // this.paymentService.send(this.formFields);
      this.formFields = res;
      for (let f of this.formFields) {
        var t = new Template();
        t.id = f.id;
        t.value = "";
        this.templates.push(t);
      }
    });
  }

  // ngAfterViewChecked() {
  //   this.dataAvailable = true;
  //   this.cdRef.detectChanges();
  // }

  // ngOnDestroy(): void {
  //   this.subscriptions.unsubscribe();
  // }

  back() {
    this.router.navigate(["/magazine/" + this.magazineId]);
  }

  submit() {
    for (let t of this.templates) {
      this.response.push({ id: t.id, value: t.value });
    }
    this.response.push({
      id: "successUrl",
      value: CLIENT_URL + "/paymentSuccess"
    });
    this.response.push({
      id: "failedUrl",
      value: CLIENT_URL + "/paymentFailed"
    });
    this.response.push({
      id: "errorUrl",
      value: CLIENT_URL + "/paymentError"
    });
    console.log(this.response);
    var paymentType = localStorage.getItem("current-payment-type");
    // kids, don't try this at home:
    this.magazineService.pay(this.response, this.instance).subscribe(
      res => {
        console.log(res);
        location.href = res;
        return res;
      },
      res => {
        console.log(res);
        location.href = res.error.text;
        return res;
      }
    );
    // this.magazineService
    //   .pay(this.response, this.instance)
    //   .subscribe(res => res);
  }
}
