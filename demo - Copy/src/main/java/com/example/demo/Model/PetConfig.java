package com.example.demo.Model;

import com.example.demo.Repository.PetRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PetConfig {

    @Bean
    CommandLineRunner commandLineRunner(PetRepository repository){
        return args -> {
            Pet mali = new Pet(
                    "Mali",
                    "Razvan",
                    "dog",
                    "Belgian Malinois",
                    4
            );
            Pet mia = new Pet(
                    "Mia",
                    "David",
                    "cat",
                    "russian blue",
                    3
            );

            repository.saveAll(
                    List.of(mali, mia)
            );
        };
    }
}
