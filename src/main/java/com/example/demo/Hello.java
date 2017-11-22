package com.example.demo;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Hello {
    @Bean
    public String wow(){
        return "wow";
    }

    public static void main(String [] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(Hello.class);
    }


}
