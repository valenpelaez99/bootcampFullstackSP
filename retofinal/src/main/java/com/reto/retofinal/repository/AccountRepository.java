package com.reto.retofinal.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reto.retofinal.entity.Account;
import com.reto.retofinal.entity.Client;

@Repository

public interface AccountRepository extends JpaRepository<Account,Integer>{
	
	Account findByAccountNumber(String accountNumber);
	
	List<Account> findByidClient (Client idClient);

}
