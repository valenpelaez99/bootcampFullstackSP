package com.reto.retofinal.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reto.retofinal.entity.Account;
import com.reto.retofinal.entity.Transaction;
import com.reto.retofinal.repository.AccountRepository;
import com.reto.retofinal.repository.TransactionRepository;

@Service

public class TransactionServiceImplementation implements TransactionService {
	
	@Autowired
	TransactionRepository transactionRepository;
	@Autowired
	AccountRepository accountRepository;

	@Override
	public Transaction createTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		
		if (transaction.getTransactionType().equalsIgnoreCase("consignment") 
				|| transaction.getTransactionType().equalsIgnoreCase("withdrawal") 
				|| transaction.getTransactionType().equalsIgnoreCase("transfer")) {	

			
			Account accountTransaction = accountRepository.findByAccountNumber(transaction.getAccountNumber());
			
			if (accountTransaction == null) {
				System.out.println("inexistent account");
				return null;
			}
			
			FinantialMovements finantialMovements = new FinantialMovements();
			float balance = finantialMovements.finantialMovements(transaction.getValue(), accountTransaction.getBalance(), transaction.getMovementType());
			

			if (accountTransaction.getAccountType().equalsIgnoreCase("saving") && transaction.getBalance() < 0) {
				return null;
			}
			
			if (accountTransaction.getAccountType().equalsIgnoreCase("checking") && transaction.getBalance() < -3000000) {
				return null;
			}
			
			if (accountTransaction.getAccountStatus() == null) {
				System.out.println("Cant find account status");
				return null;
			}
			
			if (accountTransaction.getAccountStatus().equalsIgnoreCase("inactive") && transaction.getMovementType().equalsIgnoreCase("debit")) {
				return null;
			}	
			
			transaction.setIdAccount(accountTransaction);	
			transaction.setBalance(balance);
			transaction.setAvailableBalance(balance);
			transaction.setMovementDate(LocalDate.now());
			accountTransaction.setBalance(balance);
			accountTransaction.setAvailableBalance(balance);
						
			if (transaction.getTransactionType().equalsIgnoreCase("transfer")){
				
				Account transferAccount = accountRepository.findByAccountNumber(transaction.getTransferAccount());
				
				if (transferAccount == null) {
					System.out.println("inexistent transfer account");
					return null;
				}
				
				float transferbalance = finantialMovements.finantialMovements(transaction.getValue(), transferAccount.getBalance(), "credit");
				
		
				transferAccount.setBalance(transferbalance);
				transferAccount.setAvailableBalance(transferbalance);				
				
				if (transferAccount.getAccountType().equalsIgnoreCase("checking") && transferbalance < 0) {
					transferAccount.setAvailableBalance(3000000+transferbalance);
		
				}
				
			}
			
			if (accountTransaction.getAccountType().equalsIgnoreCase("checking") && transaction.getBalance() < 0) {
				transaction.setAvailableBalance(3000000+balance);
				accountTransaction.setAvailableBalance(3000000+balance);
			}
			
			return transactionRepository.save(transaction);			
			
			
		}
		
		return null;
	}

	@Override
	public List<Transaction> getallTransaction() {
		// TODO Auto-generated method stub
		return transactionRepository.findAll();
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

	@Override
	public Transaction findByAccountNumber(String accountNumber) {
		// TODO Auto-generated method stub
		return transactionRepository.findByAccountNumber(accountNumber);
	}

	@Override
	public List<Transaction> findByidAccount(Account idAccount) {
		// TODO Auto-generated method stub
		return transactionRepository.findByidAccount(idAccount);
	}


}
