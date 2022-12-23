package com.reto.retofinal.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reto.retofinal.entity.Client;
import com.reto.retofinal.repository.ClientRepository;

@Service

public class ClientServiceImplementation implements ClientService{

	@Autowired
	ClientRepository clientRepository;
	
	@Override
	public Client createClient(Client client) {
		// TODO Auto-generated method stub
		client.setCreationDate(LocalDate.now());
		return clientRepository.save(client);
	}

	@Override
	public List<Client> getallClients() {
		// TODO Auto-generated method stub
		return clientRepository.findAll();
	}

	@Override
	public boolean deleteClientById(int id) {
		// TODO Auto-generated method stub
		
		clientRepository.deleteById(id);
		return true;
		
	}
	

}
