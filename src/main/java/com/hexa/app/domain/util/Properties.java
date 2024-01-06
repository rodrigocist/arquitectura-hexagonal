package com.hexa.app.domain.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class Properties {

    @Autowired
    private MessageSource messageSource;

    public String getMessage(String message) {
        return messageSource.getMessage(message, null, Locale.ENGLISH);
    }

}
