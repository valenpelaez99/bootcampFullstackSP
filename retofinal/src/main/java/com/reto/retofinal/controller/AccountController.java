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
import com.reto.retofinal.service.AccountService;

@RestController
@RequestMapping("/accounts")

public class AccountController {

	@Autowired
	AccountService accountService;
	
	@GetMapping
    public ResponseEntity<List<Account>> getAccount(){
		return new ResponseEntity<>(accountService.getallAccounts(), HttpStatus.OK);
	}
	
	@PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account){
		
        if (accountService.createAccount(account) != null){
            return new ResponseEntity<>(account, HttpStatus.CREATED);
        }
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        
        
    
    }
	
	@PutMapping("/{id}")
    public ResponseEntity<Account> updateAccount(@RequestBody Account account){
		
        if (accountService.updateAccount(account) != null){
            return new ResponseEntity<>(account, HttpStatus.OK);
        }
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);		
	
	}
        
    @DeleteMapping("/{id}")
    public ResponseEntity deleteAccountById(@PathVariable("id") int idAccount){
    	
        if (accountService.deleteAccountById(idAccount)){
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
	
}
    
}