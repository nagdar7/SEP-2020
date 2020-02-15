package com.sep.BitCoin.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Order {
    private String orderId;
    private Double priceAmount;
    private String priceCurrency;
    private String receiveCurrency;
    private String title;
    private String description;
    private String callbackUrl;
    private String cancelUrl;
    private String successUrl;
    private String token;
}