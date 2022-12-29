package com.reto.retofinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reto.retofinal.entity.Transaction;
import com.reto.retofinal.repository.TransactionRepository;

@Service

public class TransactionServiceImplementation implements TransactionService {
	
	@Autowired
	TransactionRepository transactionRepository;

	@Override
	public Transaction createTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		
		if (transaction.getTransactionType().equalsIgnoreCase("consignment") || transaction.getTransactionType().equalsIgnoreCase("withdrawal") || transaction.getTransactionType().equalsIgnoreCase("transfer"))  {	
			
			
			return transactionRepository.save(transaction);
		}
		
		return null;
	}

	@Override
	public List<Transaction> getallTransaction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transaction updateTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteTransactionById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
