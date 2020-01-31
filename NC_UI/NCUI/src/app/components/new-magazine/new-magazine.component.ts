import { Component, OnInit } from '@angular/core';
import { NewMagazineService } from 'src/app/services/newMagazine.service';
import { Magazine } from 'src/app/model/magazine';
import { Seller } from 'src/app/model/seller';

@Component({
  selector: 'app-new-magazine',
  templateUrl: './new-magazine.component.html',
  styleUrls: ['./new-magazine.component.scss']
})
export class NewMagazineComponent implements OnInit {

  services:string[] = [];

  magazine:Magazine;
  seller:Seller;
  temp:string[];

  constructor(
    private newMagazineService: NewMagazineService
  ) { }

  ngOnInit() {
    this.magazine = new Magazine();
    this.newMagazineService.getPaymentMethods().subscribe( res => {
      this.services = res;
    });
    this.temp = [];
  }

  save(){
    this.seller = new Seller();
    this.seller.name = this.magazine.name;
    this.seller.pib = this.magazine.pib;
    this.seller.payments = this.temp;
    this.newMagazineService.insertNewMagazine(this.magazine).subscribe( res => {
      //console.log(res);
    });
    this.newMagazineService.insertSeller(this.seller).subscribe( result => {
     // console.log(result);
    })
  }

  check(event:any, index:any, s:string){
    if(event.target.checked){
      this.temp.push(this.services[index]);
    }else{
      var i = this.temp.findIndex((element) => element == s);
      this.temp.splice(i, 1);;
    }
  }

}
