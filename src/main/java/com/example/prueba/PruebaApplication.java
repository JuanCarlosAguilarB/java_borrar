package com.example.prueba;

import com.example.prueba.service.UserService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PruebaApplication implements CommandLineRunner {

    private final Logger log = org.slf4j.LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {
        SpringApplication.run(PruebaApplication.class, args);
    }

    @Autowired
    private UserService userService;


    @Override
    public void run(String... args) throws Exception {
//        System.out.println(userService.findAll());
        log.info("Hola mundo");
        log.info("users --->  :{}", userService.findAll());
    }

}
