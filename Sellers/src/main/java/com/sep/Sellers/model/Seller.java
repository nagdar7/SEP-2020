package com.sep.Sellers.model;

import java.util.ArrayList;

/**
 * Seller
 */
public class Seller {

    private String name;
    private String pib;
    private ArrayList<String> paymentTypes;

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
    public ArrayList<String> getPaymentTypes() {
        return paymentTypes;
    }

    /**
     * @param paymentTypes the paymentTypes to set
     */
    public void setPaymentTypes(ArrayList<String> paymentTypes) {
        this.paymentTypes = paymentTypes;
    }

    public Seller() {
    }

    public Seller(String name, String pib) {
        this();
        this.name = name;
        this.pib = pib;
    }

}
