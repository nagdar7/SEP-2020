package com.sep.Banka.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

public class BankAccountDTO implements Serializable {
    private String pan;
    private String securityCode;
    private String cardHolderName;
    private String expiryYear;
    private String expiryMonth;

    private String successUrl;
    private String failedUrl;
    private String errorUrl;

    public BankAccountDTO() {
    }

    public BankAccountDTO(String pan, String securityCode, String cardHolderName, String expiryYear, String expiryMonth,
            String successUrl, String failedUrl, String errorUrl) {
        this.pan = pan;
        this.securityCode = securityCode;
        this.cardHolderName = cardHolderName;
        this.expiryYear = expiryYear;
        this.expiryMonth = expiryMonth;
        this.successUrl = successUrl;
        this.failedUrl = failedUrl;
        this.errorUrl = errorUrl;
    }

    public String getPan() {
        return this.pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getSecurityCode() {
        return this.securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public String getCardHolderName() {
        return this.cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getExpiryYear() {
        return this.expiryYear;
    }

    public void setExpiryYear(String expiryYear) {
        this.expiryYear = expiryYear;
    }

    public String getExpiryMonth() {
        return this.expiryMonth;
    }

    public void setExpiryMonth(String expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    public String getSuccessUrl() {
        return this.successUrl;
    }

    public void setSuccessUrl(String successUrl) {
        this.successUrl = successUrl;
    }

    public String getFailedUrl() {
        return this.failedUrl;
    }

    public void setFailedUrl(String failedUrl) {
        this.failedUrl = failedUrl;
    }

    public String getErrorUrl() {
        return this.errorUrl;
    }

    public void setErrorUrl(String errorUrl) {
        this.errorUrl = errorUrl;
    }

    public BankAccountDTO pan(String pan) {
        this.pan = pan;
        return this;
    }

    public BankAccountDTO securityCode(String securityCode) {
        this.securityCode = securityCode;
        return this;
    }

    public BankAccountDTO cardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
        return this;
    }

    public BankAccountDTO expiryYear(String expiryYear) {
        this.expiryYear = expiryYear;
        return this;
    }

    public BankAccountDTO expiryMonth(String expiryMonth) {
        this.expiryMonth = expiryMonth;
        return this;
    }

    public BankAccountDTO successUrl(String successUrl) {
        this.successUrl = successUrl;
        return this;
    }

    public BankAccountDTO failedUrl(String failedUrl) {
        this.failedUrl = failedUrl;
        return this;
    }

    public BankAccountDTO errorUrl(String errorUrl) {
        this.errorUrl = errorUrl;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof BankAccountDTO)) {
            return false;
        }
        BankAccountDTO bankAccountDTO = (BankAccountDTO) o;
        return Objects.equals(pan, bankAccountDTO.pan) && Objects.equals(securityCode, bankAccountDTO.securityCode)
                && Objects.equals(cardHolderName, bankAccountDTO.cardHolderName)
                && Objects.equals(expiryYear, bankAccountDTO.expiryYear)
                && Objects.equals(expiryMonth, bankAccountDTO.expiryMonth)
                && Objects.equals(successUrl, bankAccountDTO.successUrl)
                && Objects.equals(failedUrl, bankAccountDTO.failedUrl)
                && Objects.equals(errorUrl, bankAccountDTO.errorUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pan, securityCode, cardHolderName, expiryYear, expiryMonth, successUrl, failedUrl,
                errorUrl);
    }

    @Override
    public String toString() {
        return "{" + " pan='" + getPan() + "'" + ", securityCode='" + getSecurityCode() + "'" + ", cardHolderName='"
                + getCardHolderName() + "'" + ", expiryYear='" + getExpiryYear() + "'" + ", expiryMonth='"
                + getExpiryMonth() + "'" + ", successUrl='" + getSuccessUrl() + "'" + ", failedUrl='" + getFailedUrl()
                + "'" + ", errorUrl='" + getErrorUrl() + "'" + "}";
    }

}
