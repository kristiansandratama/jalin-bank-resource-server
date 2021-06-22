package com.jalin.resourceserver.module.account.repository;

import com.jalin.resourceserver.module.account.entity.Account;
import com.jalin.resourceserver.module.account.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
    @Query("SELECT t FROM Transaction t WHERE t.account = :account " +
            "AND t.transactionDate = :transactionDate " +
            "ORDER BY t.createdDate ASC")
    List<Transaction> findByAccountAndTransactionDate(Account account, LocalDate transactionDate);
}
