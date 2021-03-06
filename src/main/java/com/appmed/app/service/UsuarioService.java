package com.appmed.app.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appmed.app.domain.Usuario;
import com.appmed.app.repository.UsuarioRepository;

@Service
public class UsuarioService implements Serializable {

    private static final long serialVersionUID = 7398419783021583351L;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EmailService emailService;

    public Usuario save(Usuario usuario) {
        usuario = this.usuarioRepository.save(usuario);
        return usuario;
    }

    public Usuario findById(String id) {
        return this.usuarioRepository.findOne(id);
    }

    public List<Usuario> findAll() {
        return this.usuarioRepository.findAll();
    }

    public void delete(String id) {
        this.usuarioRepository.delete(id);
    }

    public List<Usuario> findUserByNome(String nome) {
        return (List<Usuario>) usuarioRepository.findByNome(nome);
    }

    public Usuario authenticate(String email, String password) {
        Usuario usuario = usuarioRepository.authenticate(email, password);
        this.emailService.sendUsuarioConfirmationHtmlEmail(usuario);
        return usuario;
    }

}
