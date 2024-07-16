package com.devsuperior.crud_of_costumers.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.crud_of_costumers.repositories.ClientRepository;

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository repository;
    
}
