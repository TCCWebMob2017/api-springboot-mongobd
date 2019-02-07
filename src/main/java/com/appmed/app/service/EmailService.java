
package com.appmed.app.service;

import com.appmed.app.domain.Usuario;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.SimpleMailMessage;

public interface EmailService {
    void sendCreatedAccount(Usuario usuario);
    
    void sendEmail(SimpleMailMessage msg);
    
    void sendUsuarioConfirmationHtmlEmail(Usuario usuario); 
    
    void sendHtmlEmail(MimeMessage msg); 
    
    void sendNewPasswordEmail(Usuario usuario, String newPass);
}
