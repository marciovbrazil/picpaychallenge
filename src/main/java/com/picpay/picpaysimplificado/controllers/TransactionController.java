package com.picpay.picpaysimplificado.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.picpay.picpaysimplificado.domain.transactions.Transaction;
import com.picpay.picpaysimplificado.dtos.TransactionDTO;
import com.picpay.picpaysimplificado.services.TransactionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



/**
 * TransactionController
 */
@RestController
@RequestMapping("/transactions")

public class TransactionController {

    private final TransactionService transactionService;

    TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
    
    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionDTO transactionDTO) throws Exception {
        Transaction newTransaction = this.transactionService.createTransaction(transactionDTO);
        return new ResponseEntity<>(newTransaction, HttpStatus.CREATED);
    }
    
}