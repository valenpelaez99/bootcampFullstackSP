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
		
		AgeCalculator ageCalculator = new AgeCalculator();
		int age = ageCalculator.calculateAge(client.getBirthDate(), LocalDate.now());
		 if (age>=18) {
	            client.setCreationDate(LocalDate.now());
	            client.setUserCreation("admin");
	            client.setUserModification("admin");
	            return clientRepository.save(client);
	        } 
	        return null;
		
	}

	@Override
	public List<Client> getallClients() {
		// TODO Auto-generated method stub
		return clientRepository.findAll();
	}

	@Override
	public Client updateClient(Client client) {
		// TODO Auto-generated method stub
		
		client.setModificationDate(LocalDate.now());
		return clientRepository.save(client);
	}
	
	
	@Override
	public boolean deleteClientById(int id) {
		// TODO Auto-generated method stub
		
		clientRepository.deleteById(id);
		return true;
		
	}


	

}
