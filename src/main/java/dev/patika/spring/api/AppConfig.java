package dev.patika.spring.api;

import dev.patika.spring.business.concretes.CurrencyService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class AppConfig {

    @Bean
    public CurrencyService getCurrencyService(){
        return new CurrencyService();
    }

}
