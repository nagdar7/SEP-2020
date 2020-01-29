import { Component, OnInit } from '@angular/core';
import { NewMagazineService } from 'src/app/services/newMagazine.service';

@Component({
  selector: 'app-new-magazine',
  templateUrl: './new-magazine.component.html',
  styleUrls: ['./new-magazine.component.scss']
})
export class NewMagazineComponent implements OnInit {

  services:any[];

  constructor(
    private newMagazineService: NewMagazineService
  ) { }

  ngOnInit() {
    this.newMagazineService.getPaymentUI().subscribe( res => {
      console.log(res);
    });
  }

}
