package com.devsuperior.crud_of_costumers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.crud_of_costumers.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{
    
}
