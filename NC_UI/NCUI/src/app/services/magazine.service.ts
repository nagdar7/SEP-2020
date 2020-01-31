import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';
import { Magazine } from 'src/app/model/magazine';


const httpOptions = {
  headers: new HttpHeaders({ 'content-type': 'application/json' })
};


@Injectable()
export class MagazineService {
  private headers = new HttpHeaders({'Content-Type': 'application/json'});
  constructor(private http: HttpClient) {
  }

  getAllMagazines(): Observable<Magazine[]>{
    return this.http.get<Magazine[]>("http://localhost:8080/api/getMagazines",{headers: this.headers});
  }
}
