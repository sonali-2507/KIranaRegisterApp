package com.kiranastore.transactionmanagement.models;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionRequest extends BaseTransaction {
    private String productName;
    private int quantity;
    private double rate;

    private String currency;
    @Enumerated(EnumType.ORDINAL)
    private PaymentType paymentType;

    @Override
    public String toString() {
        return "TransactionRequest{" +
                "productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", rate=" + rate +
                ", currency='" + currency + '\'' +
                ", paymentType=" + paymentType +
                '}';
    }
}
