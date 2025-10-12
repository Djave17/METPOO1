package com.uam.cised.cisedapplication;

import com.uam.cised.cisedapplication.domain.model.Facultad;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CisedApplication {

    public static void main(String[] args) {
        SpringApplication.run(CisedApplication.class, args);

        Facultad facultad = new Facultad(1L, "Facultad de ingeniería y arquitectura");
        System.out.println("Facultad creada: " + facultad.getNombre());



    }

}

