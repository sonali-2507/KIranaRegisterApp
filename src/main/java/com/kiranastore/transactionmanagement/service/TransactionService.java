package com.kiranastore.transactionmanagement.service;

import com.kiranastore.transactionmanagement.models.Transaction;
import com.kiranastore.transactionmanagement.models.TransactionRequest;
import com.kiranastore.transactionmanagement.repositories.TransactionRepository;
import com.kiranastore.transactionmanagement.utils.TransactionAdapterUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService implements ITransactionService{
    @Autowired
    private TransactionRepository transactionRepository;
    private List<Transaction> transactions = new ArrayList<>();
    private int transactionId = 1;

    @Override
    public Transaction saveTransaction(TransactionRequest transactionRequest) {
        Transaction transaction = TransactionAdapterUtil.bindTransaction(transactionRequest);
        transactionRepository.save(transaction);
        transactions.add(transaction);
        return  transaction;
    }

    @Override
    public List<Transaction> getTransaction() {
        return transactions;
    }

    @Override
    public Transaction getTransactionById(Integer id) {
        for (Transaction transaction :transactions){
            if(transaction.getTransactionId() == id){
                return transaction;
            }
        }
        return null;
    }




}
