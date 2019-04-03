package com.appmed.app.service;

import com.appmed.app.domain.Contato;
import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.net.URI;
import org.springframework.web.multipart.MultipartFile;
import com.appmed.app.domain.Usuario;
import com.appmed.app.domain.UsuarioDTO;
import com.appmed.app.repository.UsuarioRepository;
import com.appmed.app.security.UserSS;
import com.appmed.app.exceptions.AuthorizationException;
import org.springframework.security.core.context.SecurityContextHolder;

import java.awt.image.BufferedImage;
import org.springframework.beans.factory.annotation.Value;

@Service
public class UsuarioService implements Serializable {

    private static final long serialVersionUID = 7398419783021583351L;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private ContatoService contatoService;

    @Autowired
    private S3Service s3Service;

    @Autowired
    private ImageService imageService;

    @Value("${img.prefix.client.profile}")
    private String prefix;

    @Value("${img.profile.size}")
    private Integer size;

    public Usuario save(Usuario usuario) {
        return this.usuarioRepository.save(usuario);
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

    public List<UsuarioDTO> findUserByNome(String nome) {
        return (List<UsuarioDTO>) usuarioRepository.findByNome(nome);
    }

    public Usuario findByEmail(String email) {
        return (Usuario) usuarioRepository.findByEmail(email);
    }

    public List<Contato> getPossoVer() {
        return this.contatoService.getPossoVer(this.find().getId());
    }

    public List<Contato> getPossoEditar() {
        return this.contatoService.getPossoEditar(this.find().getId());
    }

    public List<Contato> getPodemVer() {
        return this.contatoService.getPodemVer(this.find().getId());
    }

    public List<Contato> getPodemEditar() {
        return this.contatoService.getPodemEditar(this.find().getId());
    }

    public URI uploadProfilePicture(MultipartFile multipartFile) {
        UserSS user = this.authenticated();
        if (user == null) {
            throw new AuthorizationException("Acesso negado");
        }
        BufferedImage jpgImage = imageService.getJpgImageFromFile(multipartFile);
        jpgImage = imageService.cropSquare(jpgImage);
        jpgImage = imageService.resize(jpgImage, size);
        String fileName = prefix + user.getId() + ".jpg";

        return s3Service.uploadFile(imageService.getInputStream(jpgImage, "jpg"), fileName, "image");
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
