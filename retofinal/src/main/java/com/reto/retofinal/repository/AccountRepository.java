package com.reto.retofinal.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reto.retofinal.entity.Account;

@Repository

public interface AccountRepository extends JpaRepository<Account,Integer>{
	Account findByAccountNumber(String accountNumber);

}
