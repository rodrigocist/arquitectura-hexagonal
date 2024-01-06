package com.hexa.app.infrastructure.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class MessageConfig {

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource
                = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames(
                "classpath:/messages/error-message"
        );
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }


   /* @Autowired
    MessageSource messageSource;

    @Bean
    public LocalValidatorFactoryBean getValidator() {
        LocalValidatorFactoryBean validatorFactory = new LocalValidatorFactoryBean();
        validatorFactory.setValidationMessageSource(messageSource);
        return validatorFactory;
    }
*/


}
