package com.reto.retofinal.service;

import java.util.List;

import com.reto.retofinal.entity.Account;
import com.reto.retofinal.entity.Client;

public interface AccountService {

	public Account createAccount(int clientId, Account account);
	public List<Account> getallAccounts();
	public Account updateAccount(int id, Account account);
	Account findByAccountNumber(String accountNumber);
	List<Account> findByidClient (Client idClient);
	public boolean deleteAccountById(int id);
	
}
