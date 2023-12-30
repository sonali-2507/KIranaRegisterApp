package com.kiranastore.transactionmanagement.service;

import com.kiranastore.transactionmanagement.models.Transaction;
import com.kiranastore.transactionmanagement.models.TransactionRequest;

import java.util.List;

public interface ITransactionService {
    public Transaction saveTransaction(TransactionRequest transactionRequest);

   List<Transaction> getTransaction();

    Transaction getTransactionById(Long id);
}
