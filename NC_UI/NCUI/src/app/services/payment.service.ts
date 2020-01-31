import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Subject } from 'rxjs/internal/Subject';
import { FormField } from 'src/app/model/formField';

@Injectable()
export class PaymentService {
send$: Observable<any>;
private sendSubject: Subject<any> = new Subject();

constructor() {
  this.send$ = this.sendSubject.asObservable();
}

public send(formFields : FormField[]) {
   this.sendSubject.next(formFields);
}


}