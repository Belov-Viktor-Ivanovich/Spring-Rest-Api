package ru.below.testdto.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfigure {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
