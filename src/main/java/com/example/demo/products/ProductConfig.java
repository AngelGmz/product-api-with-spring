package com.example.demo.products;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class ProductConfig {

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository repository) {
        return args -> {
            Product mango = new Product(
                    "Mango Tropicana",
                    "Fruit",
                    9.99D,
                    "De hoy",
                    "Nuevo",
                    LocalDate.of(2000, Month.MAY, 9)
            );
            Product watermelon = new Product(
                    "watermelon Tropicana",
                    "Fruit",
                    9D,
                    "De hoy",
                    "Nuevo",
                    LocalDate.of(2022, Month.MAY, 1)
            );

            repository.saveAll(
                    List.of(mango, watermelon)
            );
        };
    }
}
