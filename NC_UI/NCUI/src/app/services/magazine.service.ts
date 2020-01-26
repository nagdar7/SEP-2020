import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';


const httpOptions = {
  headers: new HttpHeaders({ 'content-type': 'application/json' })
};


@Injectable()
export class MagazineService {
  private headers = new HttpHeaders({'Content-Type': 'application/json'});
  constructor(private http: HttpClient) {
  }

  getAllMagazines(){
    return this.http.get<string[]>("http://localhost:8080/api/getMagazines",{headers: this.headers, observe: 'response'});
  }
}
