import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';
import { Magazine } from 'src/app/model/magazine';
import { Seller } from 'src/app/model/seller';


const httpOptions = {
  headers: new HttpHeaders({ 'content-type': 'application/json' })
};


@Injectable()
export class NewMagazineService {
  private headers = new HttpHeaders({'Content-Type': 'application/json'});
  constructor(
    private http: HttpClient
  ) {
  }

  getPaymentMethods(): Observable<string[]>{
    return this.http.get<string[]>("http://localhost:8080/api/getPaymentMethods/eureka",{headers: this.headers});
  }

  insertNewMagazine(magazine: Magazine): Observable<Magazine>{
    return this.http.post<Magazine>("http://localhost:8080/api/insertMagazine", magazine, {headers:this.headers});
  }

  insertSeller(seller: Seller): Observable<string>{
    return this.http.post<string>("http://localhost:8080/api/addSeller", seller, {headers:this.headers});
  }
}
