package com.appmed.app.service;

import com.appmed.app.domain.Pessoal;
import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appmed.app.domain.Usuario;
import com.appmed.app.domain.enums.TipoUsuario;
import com.appmed.app.repository.UsuarioRepository;
import com.appmed.app.security.UserSS;
import com.appmed.app.exceptions.AuthorizationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
        //UserSS user;
        //user = authenticated();
        //if (user == null || !user.hasRole(TipoUsuario.ADMIN) && !id.equals(user.getId())) {
        //    throw new AuthorizationException("Acesso negado");
        //}
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

    public static UserSS authenticated() {
        try {
            return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e) {
            return null;
        }
    }

    public Usuario find() {
        UserSS user = UsuarioService.authenticated();
        if (user == null) {
            throw new AuthorizationException("Acesso negado");
        }
        Usuario usuario = this.findById(user.getId());
        return usuario;
    }
}
