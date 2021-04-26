package com.ciechmar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
public class ToDoListApplication implements RepositoryRestConfigurer {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        SpringApplication.run(ToDoListApplication.class, args);
    }

    @Override
    public void configureValidatingRepositoryEventListener(final ValidatingRepositoryEventListener validatingListener) {
//        RepositoryRestConfigurer.super.configureValidatingRepositoryEventListener(validatingListener);
        validatingListener.addValidator("beforeCreated", validator());
        validatingListener.addValidator("beforeSave", validator());
    }

    @Bean
    Validator validator() {
        return new LocalValidatorFactoryBean();
    }
}
