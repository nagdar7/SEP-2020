import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';
import { Magazine } from 'src/app/model/magazine';
import { FormField } from 'src/app/model/formField';


const httpOptions = {
  headers: new HttpHeaders({ 'content-type': 'application/json' })
};


@Injectable()
export class MagazineService {
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });
  constructor(private http: HttpClient) {
  }

  getAllMagazines(): Observable<Magazine[]> {
    return this.http.get<Magazine[]>("http://localhost:8080/api/getMagazines", { headers: this.headers });
  }

  getAllPaymentTypes(pib: string): Observable<string[]> {
    return this.http.get<string[]>("http://localhost:8080/api/getPaymentTypesForMagazine/" + pib, { headers: this.headers });
  }

  paymentUI(paymentType: string): Observable<FormField[]> {
    return this.http.get<FormField[]>("http://localhost:8080/api/payment-subscriptions/" + paymentType.toLowerCase(), { headers: this.headers });
  }

  pay(paymentType: string, template: any[]): any {
    return this.http.post<string>("http://localhost:8080/api/payment-subscriptions/" + paymentType.toLowerCase(), template, { headers: this.headers });
  }
}
