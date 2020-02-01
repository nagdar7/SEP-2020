import { Component, OnInit, Input, ChangeDetectorRef } from '@angular/core';
import { FormField } from 'src/app/model/formField';
import { OnDestroy } from '@angular/core/src/metadata/lifecycle_hooks';
import { Subscription } from 'rxjs/internal/Subscription';
import { PaymentService } from 'src/app/services/payment.service';
import { Template } from 'src/app/model/template';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.scss']
})
export class PaymentComponent implements OnInit, OnDestroy {

    private subscriptions: Subscription = new Subscription();

    private formFields: FormField[];
    private templates: Template[] = [];
    private dataAvailable:boolean = false;
    private response:any[] = [];

    constructor(
        private paymentService: PaymentService,
        private cdRef : ChangeDetectorRef
    ) { }

    ngOnInit() {
        this.subscriptions.add(this.paymentService.send$.subscribe(res => {
            this.formFields = res;
            for(let f of this.formFields){
                var t = new Template();
                t.id = f.id;
                t.value = "";
                this.templates.push(t);
            }
        }));
    }

    ngAfterViewChecked(){
        this.dataAvailable = true;
        this.cdRef.detectChanges();
    }

    ngOnDestroy(): void {
        this.subscriptions.unsubscribe();
    }

    submit(){
        for(let t of this.templates){
            this.response.push({id: t.id, value: t.value});
        }
        this.response.push({id: "successUrl", value: "http://localhost:4200/"});
        this.response.push({id: "failedUrl", value: "http://localhost:4200/"});
        this.response.push({id: "errorUrl", value: "http://localhost:4200/"});
        console.log(this.response);
    }

}
