package com.picpay.picpaysimplificado.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.picpay.picpaysimplificado.domain.transactions.Transactions;

/**
 * TransactionRepository
 */
public interface TransactionRepository extends JpaRepository<Transactions, Long> {

    
}