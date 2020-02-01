package com.sep.Issuer.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PCCRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long acquirerOrderId;
    @Column
    private Date acquirerTimestamp;
    @Column
    private String buyersPan;
    @Column
    private BankAccount bankAccount;

    public PCCRequest() {
        super();
    }

    public long getAcquirerOrderId() {
        return acquirerOrderId;
    }

    public void setAcquirerOrderId(long acquirerOrderId) {
        this.acquirerOrderId = acquirerOrderId;
    }

    public Date getAcquirerTimestamp() {
        return acquirerTimestamp;
    }

    public void setAcquirerTimestamp(Date acquirerTimestamp) {
        this.acquirerTimestamp = acquirerTimestamp;
    }

    public String getBuyersPan() {
        return buyersPan;
    }

    public void setBuyersPan(String buyersPan) {
        this.buyersPan = buyersPan;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

}
