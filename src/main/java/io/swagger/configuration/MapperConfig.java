package io.swagger.configuration;

import io.swagger.mapper.GarageMapper;
import io.swagger.mapper.UserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public UserMapper userMapper() {
        return new UserMapper();
    }
    @Bean
    public GarageMapper garageMapper() {return new GarageMapper();}
}
