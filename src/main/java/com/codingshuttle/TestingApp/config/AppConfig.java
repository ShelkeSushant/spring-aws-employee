package com.codingshuttle.TestingApp.config;

import com.codingshuttle.TestingApp.dto.EmployeeDto;
import com.codingshuttle.TestingApp.entities.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.typeMap(Employee.class, EmployeeDto.class)
                .addMapping(Employee::getFullName, EmployeeDto::setName);
        modelMapper.typeMap(EmployeeDto.class, Employee.class)
                .addMapping(EmployeeDto::getName, Employee::setFullName);
        return modelMapper;
    }
}
