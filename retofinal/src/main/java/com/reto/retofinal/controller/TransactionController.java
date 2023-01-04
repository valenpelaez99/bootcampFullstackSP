package com.reto.retofinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reto.retofinal.entity.Account;
import com.reto.retofinal.entity.Client;
import com.reto.retofinal.entity.Transaction;
import com.reto.retofinal.service.TransactionService;

@RestController
@RequestMapping("/transactions")

public class TransactionController {

	@Autowired
	TransactionService transactionService;
	
	@GetMapping
    public ResponseEntity<List<Transaction>> getTransaction(){
		return new ResponseEntity<>(transactionService.getallTransaction(), HttpStatus.OK);
	}
	
	@PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction){
		
        if (transactionService.createTransaction(transaction) != null){
            return new ResponseEntity<>(transaction, HttpStatus.CREATED);
        }
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        
        
    
    }
	
	@PutMapping("/{id}")
    public ResponseEntity<Transaction> updateTransaction(@RequestBody Transaction transaction){
		
        if (transactionService.updateTransaction(transaction) != null){
            return new ResponseEntity<>(transaction, HttpStatus.OK);
        }
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);		
	
	}
		
        
    @DeleteMapping("/{id}")
    public ResponseEntity deleteTransactionById(@PathVariable("id") int idTransaction){
    	
        if (transactionService.deleteTransactionById(idTransaction)){
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
	
}
	
}
