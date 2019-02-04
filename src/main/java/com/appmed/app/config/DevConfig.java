package com.appmed.app.config;

import com.appmed.app.service.EmailService;
import com.appmed.app.service.SmtpEmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("mlab")
public class DevConfig {

    @Bean
    public EmailService emailService() {
        return new SmtpEmailService();
    }
}
