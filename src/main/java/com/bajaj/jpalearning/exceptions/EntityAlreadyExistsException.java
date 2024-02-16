package com.bajaj.jpalearning.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;

public class EntityAlreadyExistsException extends RuntimeException{

    public EntityAlreadyExistsException(String message){
        super(message);
    }
}
