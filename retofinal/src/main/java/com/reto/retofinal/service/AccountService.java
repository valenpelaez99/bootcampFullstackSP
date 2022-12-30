package com.reto.retofinal.service;

import java.util.List;

import com.reto.retofinal.entity.Account;

public interface AccountService {

	public Account createAccount(Account account);
	public List<Account> getallAccounts();
	public Account updateAccount(Account account);
	Account findByidAccount(String accountNumber);
	public boolean deleteAccountById(int id);
	
}
