package com.reto.retofinal.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reto.retofinal.entity.Account;
import com.reto.retofinal.entity.Client;
import com.reto.retofinal.repository.AccountRepository;
import com.reto.retofinal.repository.ClientRepository;

@Service

public class AccountServiceImplementation implements AccountService {

	@Autowired
	AccountRepository accountRepository;
	ClientRepository clientRepository;
	
	@Override
	public Account createAccount(Account account) {
		
		if (account.getAccountType().equalsIgnoreCase("checking") || account.getAccountType().equalsIgnoreCase("saving"))  {
			
			AccountGenerator accountGenerator = new AccountGenerator();
			String accountNumber = accountGenerator.accountGenerator(account.getAccountType());
			Account existingAccount = accountRepository.findByAccountNumber(accountNumber);
			
			if (existingAccount == null) {
				
				account.setAccountNumber(accountNumber);
				account.setCreationDate(LocalDate.now());
	            account.setUserCreation("admin");
	            account.setUserModification("admin");
				
				
				if (account.getAccountType().equalsIgnoreCase("saving")) {
					account.setAccountStatus("Active");
					
				}
				
				return accountRepository.save(account);
				
			}
			
		}
		
		// TODO Auto-generated method stub
		return null;
		
		
	}

	@Override
	public List<Account> getallAccounts() {
		// TODO Auto-generated method stub
		return accountRepository.findAll();
	}

	@Override
	public Account updateAccount(Account account) {
		// TODO Auto-generated method stub
	
		return accountRepository.save(account);
	}

	@Override
	public boolean deleteAccountById(int idAccount) {
		// TODO Auto-generated method stub
		accountRepository.deleteById(idAccount);
		return true;
	}

	@Override
	public Account findByidClient(String accountNumber) {
		// TODO Auto-generated method stub
		return accountRepository.findByAccountNumber(accountNumber);
	}

	
}
