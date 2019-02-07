package com.appmed.app.service;

import com.appmed.app.domain.Usuario;
import java.util.Date;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

public abstract class AbstractEmailService implements EmailService {

    @Value("${default.sender}")
    private String sender;

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendCreatedAccount(Usuario usuario) {
        SimpleMailMessage sm = prepareSimpleMailMessageFromUsuario(usuario);
        sendEmail(sm);
    }

    ;

    protected SimpleMailMessage prepareSimpleMailMessageFromUsuario(Usuario usuario) {
        SimpleMailMessage sm = new SimpleMailMessage();
        sm.setTo(usuario.getEmail());
        sm.setFrom(sender);
        sm.setSubject("Conta Q-Life criada");
        sm.setSentDate(new Date(System.currentTimeMillis()));
        sm.setText(usuario.toString());
        return sm;
    }

    protected String htmlFromTemplateUsuario(Usuario usuario) {
        Context context = new Context();
        context.setVariable("usuario", usuario);
        return templateEngine.process("email/confirmacaoConta", context);
    }

    ;
    
   @Override
    public void sendUsuarioConfirmationHtmlEmail(Usuario usuario) {
        try {
            MimeMessage mm = prepareMimeMessageFromUsuario(usuario);
            sendHtmlEmail(mm);
        } catch (MessagingException e) {
            this.sendCreatedAccount(usuario);
        }
    }

    ; 

    private MimeMessage prepareMimeMessageFromUsuario(Usuario usuario) throws MessagingException {
        MimeMessage mimeMessage = this.javaMailSender.createMimeMessage();
        MimeMessageHelper mmh = new MimeMessageHelper(mimeMessage, true);
        mmh.setTo(usuario.getEmail());
        mmh.setFrom(sender);
        mmh.setSubject("Conta de usuario Q-Life Criada");
        mmh.setSentDate(new Date(System.currentTimeMillis()));
        mmh.setText(htmlFromTemplateUsuario(usuario), true);
        return mimeMessage;
    }

    @Override
    public void sendNewPasswordEmail(Usuario usuario, String newPass) {
        SimpleMailMessage sm = prepareNewPasswordEmail(usuario, newPass);
        sendEmail(sm);
    }

    protected SimpleMailMessage prepareNewPasswordEmail(Usuario usuario, String newPass) {
        SimpleMailMessage sm = new SimpleMailMessage();
        sm.setTo(usuario.getEmail());
        sm.setFrom(sender);
        sm.setSubject("Solicitação de nova senha");
        sm.setSentDate(new Date(System.currentTimeMillis()));
        sm.setText("Nova senha: " + newPass);
        return sm;
    }
}
