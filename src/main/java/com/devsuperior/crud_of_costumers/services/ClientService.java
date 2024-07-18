package com.devsuperior.crud_of_costumers.services;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.crud_of_costumers.dto.ClientDTO;
import com.devsuperior.crud_of_costumers.entities.Client;
import com.devsuperior.crud_of_costumers.repositories.ClientRepository;
import com.devsuperior.crud_of_costumers.services.exceptions.ResourceNotFoundException;

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository repository;
    
    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable){
        Page<Client> result = repository.findAll(pageable);
        return result.map(x -> new ClientDTO(x));
    }
    
    @Transactional(readOnly = true)
    public ClientDTO findById(Long id){
        Client client = repository.findById(id).orElseThrow(
                        () -> new ResourceNotFoundException("ID não encontrado."));
        return new ClientDTO(client);
    }
    
    @Transactional()
    public ClientDTO insert(ClientDTO dto){
        Client entity = new Client();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new ClientDTO(entity);
    }
    
    @Transactional()
    public ClientDTO update(Long id, ClientDTO dto){
        try {
            Client entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new ClientDTO(entity);            
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("ID "+ id +" não foi encontrado.");
        }
    }

    private void copyDtoToEntity(ClientDTO dto, Client entity) {
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setIncome(dto.getIncome());
        entity.setBirthDate(dto.getBirthDate());
        entity.setChildren(dto.getChildren());
    }
}