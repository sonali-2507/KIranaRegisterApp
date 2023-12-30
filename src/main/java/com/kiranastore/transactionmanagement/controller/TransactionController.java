package com.kiranastore.transactionmanagement.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.kiranastore.transactionmanagement.models.*;
import com.kiranastore.transactionmanagement.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction-manager")
public class TransactionController {

    @Autowired
    private ITransactionService transactionService;

    public String inputCurrency;


    @GetMapping("/transactions")
    public ResponseEntity<List<Transaction>> getTransaction() {
        var transactionList = transactionService.getTransaction();
        return  ResponseEntity.ok(transactionList);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Transaction>getTransacrtionById(@PathVariable("id") Long id){
        var transaction = transactionService.getTransactionById(id);
        return ResponseEntity.ok(transaction);
    }

    @PostMapping("/save")
    public ResponseEntity<Transaction> save(@RequestBody TransactionRequest transactionRequest)  {
       Transaction transaction = transactionService.saveTransaction(transactionRequest);
       inputCurrency = transaction.getCurrency();
       return new ResponseEntity<>(transaction, HttpStatus.CREATED);

    }



}
