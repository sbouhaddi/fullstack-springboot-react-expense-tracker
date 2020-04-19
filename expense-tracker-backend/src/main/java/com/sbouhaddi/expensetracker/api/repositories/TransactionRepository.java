package com.sbouhaddi.expensetracker.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbouhaddi.expensetracker.api.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
