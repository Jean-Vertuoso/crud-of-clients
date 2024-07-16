package com.devsuperior.crud_of_costumers.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    
    public ResourceNotFoundException(String msg){
        super(msg);
    }
}
