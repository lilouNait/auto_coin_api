package io.swagger.configuration;


import io.swagger.geocode.AddressConverter;
import io.swagger.mapper.GarageMapper;
import io.swagger.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Value("${geocode.key}")
    private String geocodeKey;

    @Bean
    public UserMapper userMapper() {
        return new UserMapper();
    }
    @Bean
    public GarageMapper garageMapper() {return new GarageMapper();}

    @Bean
    public AddressConverter addressConverter() {
        return new AddressConverter(geocodeKey);
    }
}
