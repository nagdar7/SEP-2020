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
public class OrderResponse {
    private Long id;
    private String status;
    private String priceCurrency;
    private Double priceAmount;
    private String receiveCurrency;
    private Double receiveAmount;
    private String createdAt;
    private String orderId;
    private String paymentUrl;
    private String token;
}