package com.reto.retofinal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reto.retofinal.entity.Account;
import com.reto.retofinal.entity.Client;
import com.reto.retofinal.entity.Transaction;

@Repository

public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
	
	Transaction findByAccountNumber(String accountNumber);
	List<Transaction> findByidAccount (Account idAccount);
}
