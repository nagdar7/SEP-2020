import { HOST_URL } from "./../../config";
import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs/internal/Observable";
import { Magazine } from "src/app/model/magazine";
import { Seller } from "src/app/model/seller";

const httpOptions = {
  headers: new HttpHeaders({ "content-type": "application/json" })
};

@Injectable()
export class NewMagazineService {
  private headers = new HttpHeaders({ "Content-Type": "application/json" });
  constructor(private http: HttpClient) {}

  getPaymentMethods(): Observable<string[]> {
    return this.http.get<string[]>(HOST_URL + "/api/getPaymentMethods/eureka", {
      headers: this.headers
    });
  }

  insertNewMagazine(magazine: Magazine): Observable<Magazine> {
    return this.http.post<Magazine>(
      HOST_URL + "/api/insertMagazine",
      magazine,
      { headers: this.headers }
    );
  }

  insertSeller(seller: Seller): Observable<string> {
    return this.http.post<string>(HOST_URL + "/api/addSeller", seller, {
      headers: this.headers
    });
  }
}
