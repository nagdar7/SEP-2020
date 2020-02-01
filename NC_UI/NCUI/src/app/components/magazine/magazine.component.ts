import { Component, OnInit } from '@angular/core';
import { MagazineService } from 'src/app/services/magazine.service';
import { Magazine } from 'src/app/model/magazine';
import { FormField } from 'src/app/model/formField';
import { PaymentService } from 'src/app/services/payment.service';

@Component({
  selector: 'app-magazine',
  templateUrl: './magazine.component.html',
  styleUrls: ['./magazine.component.scss'],
})
export class MagazineComponent implements OnInit {

  private magazines: Magazine[] = [];
  private showPayments:boolean = false;
  private paymentsForMagazine:string[] = [];
  private paymentChosen:boolean = false;
  private formFields:FormField[] = [];

  constructor(
    private magazineService: MagazineService,
    private paymentService: PaymentService
  ) { }

  ngOnInit() {
    this.magazineService.getAllMagazines().subscribe(
      data => {
        this.magazines = data;
      });
  }

  subscribe(m : Magazine){
    console.log("Pretplata na magazin: ");
    console.log(m);
    this.showPayments = true;
    this.magazineService.getAllPaymentTypes(m.pib).subscribe( res => {
      // console.log(res);
      this.paymentsForMagazine = res;
    });
  }

  back(){
    this.showPayments = false;
  }

  pay(paymentType:string){
    this.paymentChosen = true;
    this.magazineService.paymentUI(paymentType).subscribe(res => {
      // console.log(res);
      this.formFields = res;
      this.paymentService.send(this.formFields);
    });
  }

}
