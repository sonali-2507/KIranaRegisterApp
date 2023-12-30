package com.kiranastore.transactionmanagement.utils;

import com.kiranastore.transactionmanagement.models.*;

import java.net.UnknownServiceException;

public class TransactionAdapterUtil {
    public static Transaction bindTransaction(TransactionRequest transactionRequest){
        Transaction transaction = new Transaction();


        transaction.setProductName(transactionRequest.getProductName());
        transaction.setQuantity(transactionRequest.getQuantity());
        transaction.setRate(transactionRequest.getRate());
        transaction.setAmount(transaction.getAmountInUSD());

        transaction.setCurrency(transactionRequest.getCurrency());
        transaction.setPaymentType(transactionRequest.getPaymentType());

        return transaction;
    }
}
