package com.kiranastore.transactionmanagement.repositories;

import com.kiranastore.transactionmanagement.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {

}
