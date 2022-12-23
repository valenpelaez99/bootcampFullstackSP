package com.reto.retofinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.reto.retofinal.entity.Client;
import com.reto.retofinal.service.ClientService;

@RestController
@RequestMapping("/clients")

public class ClientController {
	
	@Autowired
	ClientService clientService;
	
	@GetMapping
    public ResponseEntity<List<Client>> getClients(){
		return new ResponseEntity<>(clientService.getallClients(), HttpStatus.OK);
	}
	
	@PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client client){
        return new ResponseEntity<>(clientService.createClient(client), HttpStatus.CREATED);
        
    
    }
	
    @DeleteMapping("/{id}")
    public ResponseEntity deleteClientById(@PathVariable("id") int id){
        
            return new ResponseEntity<>(clientService.deleteClientById(id),HttpStatus.OK);
            
        
    }
	

	
	

	
	

}
