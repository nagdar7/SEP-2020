package com.sep.Sellers.model;

import javax.persistence.*;

@Entity
public class PaymentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Integer paymentId;

    @Column(name = "payment_name")
    private String paymentName;

    @Column(name = "sellers_pib")
    private String sellerPib;

    public PaymentType() {
    }

    public PaymentType(Integer paymentId, String paymentName, String sellerPib) {
        this.paymentId = paymentId;
        this.paymentName = paymentName;
        this.sellerPib = sellerPib;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }

    public String getSellerPib() {
        return sellerPib;
    }

    public void setSellerPib(String sellerPib) {
        this.sellerPib = sellerPib;
    }
}
