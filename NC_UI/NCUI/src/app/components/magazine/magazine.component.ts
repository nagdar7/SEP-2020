import { Component, OnInit } from '@angular/core';
import { MagazineService } from 'src/app/services/magazine.service';

@Component({
  selector: 'app-magazine',
  templateUrl: './magazine.component.html',
  styleUrls: ['./magazine.component.scss'],
})
export class MagazineComponent implements OnInit {

  private magazines: string[];
  constructor(private magazineService: MagazineService) { }

  ngOnInit() {
    this.magazineService.getAllMagazines().subscribe(
      data => {
        this.magazines = data.body;
        for (let i = 0 ; i < this.magazines.length; i++){
          alert(this.magazines[i]);
        }
      });
  }

}
