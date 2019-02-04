
package com.appmed.app.config;

import com.appmed.app.service.EmailService;
import com.appmed.app.service.MockEmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {
    
    @Bean
    public EmailService emailService(){
    return new MockEmailService();}
}
