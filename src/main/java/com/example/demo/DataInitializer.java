package com.example.demo;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner loadData(EmployeeRepository employeeRepository) {
        return args -> {
            employeeRepository.save(new Employee(1L, "John Doe", 50000));
            employeeRepository.save(new Employee(2L, "Jane Smith", 60000));
            employeeRepository.save(new Employee(3L, "Alice Johnson", 55000));
        };
    }
}


