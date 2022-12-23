package com.reto.retofinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reto.retofinal.entity.Client;

@Repository

public interface ClientRepository extends JpaRepository<Client, Integer>{

}
