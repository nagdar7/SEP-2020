package com.sep.Sellers.model;

import java.util.List;

import javax.persistence.*;
//import com.sep.Sellers.model.PaymentType;

/**
 * Seller
 */

@Entity
public class Seller {

    @Column(name = "name")
    private String name;

    @Id
    @Column(name = "pib")
    private String pib;

    @ManyToMany
    private List<PaymentType> paymentTypes;

    public Seller() {
    }

    public Seller(String name, String pib) {
        this.name = name;
        this.pib = pib;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return String return the pib
     */
    public String getPib() {
        return pib;
    }

    /**
     * @param pib the pib to set
     */
    public void setPib(String pib) {
        this.pib = pib;
    }

    /**
     * @return ArrayList<PaymentType> return the paymentTypes
     */
    public List<PaymentType> getPaymentTypes() {
        return paymentTypes;
    }

    /**
     * @param paymentTypes the paymentTypes to set
     */
    public void setPaymentTypes(List<PaymentType> paymentTypes) {
        this.paymentTypes = paymentTypes;
    }

}
