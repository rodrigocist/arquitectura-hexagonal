package com.hexa.app.infrastructure.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException() {
        super();
    }

    public ResourceNotFoundException(String message) {
        super(message, null, false, false);
        log.error(message);
    }

}
