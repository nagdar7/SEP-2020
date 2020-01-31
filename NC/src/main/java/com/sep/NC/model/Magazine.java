package com.sep.NC.model;

import java.util.ArrayList;

/**
 * Seller
 */
public class Magazine {

    private String name;
    private String pib;

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

    public Magazine() {

    }

    public Magazine(String name, String pib) {
        this();
        this.name = name;
        this.pib = pib;
    }

}
