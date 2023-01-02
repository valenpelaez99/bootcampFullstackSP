package com.reto.retofinal.service;

import java.time.LocalDate;
import java.util.List;

import com.reto.retofinal.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reto.retofinal.entity.Account;
import com.reto.retofinal.repository.AccountRepository;
import com.reto.retofinal.repository.ClientRepository;

@Service
public class AccountServiceImplementation implements AccountService {

	@Autowired
	AccountRepository accountRepository;
	@Autowired
	ClientRepository clientRepository;
	
	@Override
	public Account createAccount(Account account) {
		
		if (account.getAccountType().equalsIgnoreCase("saving") && (account.getBalance() < 0)) {
			return null;
		}

		
		if (account.getAccountType().equalsIgnoreCase("checking") || account.getAccountType().equalsIgnoreCase("saving"))  {
			
			AccountGenerator accountGenerator = new AccountGenerator();
			String accountNumber = accountGenerator.accountGenerator(account.getAccountType());
			Account existingAccount = accountRepository.findByAccountNumber(accountNumber);


			
			try {

				Client client = clientRepository.getReferenceById(account.getIdclient().getIdClient());

				if(client != null && (existingAccount == null)){
					account.setAccountNumber(accountNumber);
					account.setCreationDate(LocalDate.now());
					account.setUserCreation("admin");
					account.setUserModification("admin");


					if (account.getAccountType().equalsIgnoreCase("saving")) {
						account.setAccountStatus("Active");

					}
					
						return accountRepository.save(account);

				}
			} catch (Exception e) {
				System.out.println("No hay Cliente asociado");
			}

		}

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
	public Account findByidAccount(String accountNumber) {
		// TODO Auto-generated method stub
		return accountRepository.findByAccountNumber(accountNumber);
	}

	
}