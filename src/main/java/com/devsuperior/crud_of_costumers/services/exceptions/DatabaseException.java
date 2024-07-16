package com.devsuperior.crud_of_costumers.services.exceptions;

public class DatabaseException extends RuntimeException {
    
    public DatabaseException(String message){
        super(message);
    }
}
