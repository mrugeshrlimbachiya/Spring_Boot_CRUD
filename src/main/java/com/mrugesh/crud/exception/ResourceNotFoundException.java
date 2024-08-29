package com.mrugesh.crud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception throws when a requested resource is not found.
 *
 * <p>This exception is typically used in service layers to indicate that
 * an entity (such as an employee) was not found in the database.</p>
 *
 * <p>The {@code ResourceNotFoundException} is annotated with
 * {@link ResponseStatus}, which marks the response with a 404 Not Found status
 * when the exception is thrown in a Spring Web application.</p>
 *
 * @see RuntimeException
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    /**
     * Constructs a new {@code ResourceNotFoundException} with the specified detail message.
     *
     * @param message the detail message that explains why the error was thrown to you
     */
    public ResourceNotFoundException(String message){
        super(message);
    }

}