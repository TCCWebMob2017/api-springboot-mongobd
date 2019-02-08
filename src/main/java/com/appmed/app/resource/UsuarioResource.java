package com.appmed.app.resource;

import com.appmed.app.domain.Pessoal;
import static com.appmed.app.util.ApiVersionUtil.*;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.appmed.app.domain.Usuario;
import com.appmed.app.exceptions.NotFound;
import com.appmed.app.service.EmailService;
import com.appmed.app.service.PessoalService;
import com.appmed.app.service.UsuarioService;
import static com.appmed.app.util.QRCodeReader.generateQRCodeImage;
import com.google.zxing.WriterException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = {
    REST_APP + VERSION_V1 + USUARIO
})
public class UsuarioResource implements Serializable {

    private static final long serialVersionUID = -2827532105824714138L;
    @Autowired
    private BCryptPasswordEncoder re;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PessoalService pessoalService;

    @Autowired
    private EmailService emailService;

    private final Path rootLocation = Paths.get("src/main/resources/image/");

    public String gerarBCrypt(String senha) {
        if (senha == null) {
            return senha;
        }
        return re.encode(senha);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        return ResponseEntity.status(HttpStatus.OK)
                .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                .body(this.usuarioService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable(name = "id") String id) throws NotFound {
        Usuario usuario = this.usuarioService.findById(id);

        if (usuario == null) {
            throw new NotFound("There is no user with this id!");
        }

        return ResponseEntity.status(HttpStatus.OK)
                .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                .body(usuario);
    }

    @PostMapping
    public ResponseEntity<Usuario> saveUsuario(@Valid @RequestBody Usuario usuario) {
        usuario.setPassword(this.gerarBCrypt(usuario.getPassword()));
        usuario = this.usuarioService.save(usuario);
        this.emailService.sendCreatedAccount(usuario);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(usuario);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable("id") String id, @Valid @RequestBody Usuario usuario) {
        usuario.setId(id);
        usuario.setPassword(this.gerarBCrypt(usuario.getPassword()));
        usuario = this.usuarioService.save(usuario);
        return ResponseEntity.status(HttpStatus.OK)
                .body(usuario);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteUsuario(@PathVariable String id) {
        this.usuarioService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Usuario removido");
    }

    @PostMapping(value = "/{id}/perfil/pessoal")
    public ResponseEntity<Usuario> addPerfilPessoalUsuario(@Valid @PathVariable(name = "id") String id, @Valid @RequestBody Pessoal pessoal) throws NotFound {
        Usuario usuario = this.usuarioService.findById(id);
        if (usuario == null) {
            throw new NotFound("Não existe usuário com este id!");
        }
        Pessoal perfilPessoal = this.pessoalService.save(pessoal);
        usuario.setPerfilPessoal(perfilPessoal);
        usuario = this.usuarioService.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(usuario);
    }

    @GetMapping(value = "/{id}/perfil/pessoal")
    public ResponseEntity<Pessoal> addPerfilPessoalUsuario(@PathVariable(name = "id") String id) throws NotFound {
        Usuario usuario = this.usuarioService.findById(id);
        if (usuario == null) {
            throw new NotFound("Não existe usuario com este id!");
        }
        Pessoal perfilPessoal = usuario.getPerfilPessoal();
        if (perfilPessoal == null) {
            throw new NotFound("Não existe perfil pessoal cadastrado para este usuário!");
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(perfilPessoal);
    }

    @PutMapping(value = "/{id}/perfil/pessoal")
    public ResponseEntity<Pessoal> updatePerfilPessoalUsuario(@Valid @PathVariable(name = "id") String id, @Valid @RequestBody Pessoal pessoal) throws NotFound {
        Usuario usuario = this.usuarioService.findById(id);
        if (usuario == null) {
            throw new NotFound("Não existe usuário com este id!");
        }

        Pessoal perfilPessoal = usuario.getPerfilPessoal();
        if (perfilPessoal == null) {
            throw new NotFound("Não existe perfil pessoal cadastrado para este usuário!");
        }

        pessoal.setId(perfilPessoal.getId());

        pessoal = this.pessoalService.save(pessoal);
        return ResponseEntity.status(HttpStatus.OK)
                .body(pessoal);
    }

    @DeleteMapping(value = "/{id}/perfil/pessoal")
    public ResponseEntity deletePerfilPessoalUsuario(@PathVariable String id) {
        Usuario usuario = usuarioService.findById(id);
        Pessoal perfilPessoal = usuario.getPerfilPessoal();
        usuario.setPerfilPessoal(null);
        this.usuarioService.save(usuario);
        this.pessoalService.delete(perfilPessoal.getId());
        return ResponseEntity.status(HttpStatus.OK).body("Perfil Pessoal do usuario removido");
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Usuario>> getUsuarioByNome(@PathVariable(name = "nome") String nome) throws NotFound {
        List<Usuario> usuarios = this.usuarioService.findUserByNome(nome);

        if (usuarios == null) {
            throw new NotFound("There is no user with this name!");
        }

        return ResponseEntity.status(HttpStatus.OK)
                .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                .body(usuarios);

    }

    @PostMapping(value = "{id}/perfil/pessoal/avatar")
    public ResponseEntity<String> saveAvatarPerfilPessoal(@PathVariable String id, @RequestParam("file") MultipartFile file) throws IOException, NotFound {
        Usuario usuario = this.usuarioService.findById(id);
        if (usuario == null) {
            throw new NotFound("Não existe usuário com este id!");
        }

        Pessoal perfilPessoal = usuario.getPerfilPessoal();
        if (perfilPessoal == null) {
            throw new NotFound("Não existe perfil pessoal cadastrado para este usuário!");
        }

        String filename = "avatar_" + perfilPessoal.getId() + ".png";
        Files.copy(file.getInputStream(), this.rootLocation.resolve(filename));
        return ResponseEntity.status(HttpStatus.CREATED).body("imagem salva");
    }

    @PutMapping(value = "{id}/perfil/pessoal/avatar", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<String> updateAvatarPerfilPessoal(@PathVariable String id, @RequestParam("file") MultipartFile file) throws IOException, NotFound {
        Usuario usuario = this.usuarioService.findById(id);
        if (usuario == null) {
            throw new NotFound("Não existe usuário com este id!");
        }

        Pessoal perfilPessoal = usuario.getPerfilPessoal();
        if (perfilPessoal == null) {
            throw new NotFound("Não existe perfil pessoal cadastrado para este usuário!");
        }

        String filename = "avatar_" + perfilPessoal.getId() + ".png";
        Files.copy(file.getInputStream(), this.rootLocation.resolve(filename));
        return ResponseEntity.status(HttpStatus.OK).body("imagem salva");
    }

    @GetMapping(value = "{id}/perfil/pessoal/avatar", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<InputStreamResource> getAvatarPerfilPessoal(@PathVariable String id) throws IOException, NotFound {
        Usuario usuario = this.usuarioService.findById(id);
        if (usuario == null) {
            throw new NotFound("Não existe usuário com este id!");
        }

        Pessoal perfilPessoal = usuario.getPerfilPessoal();
        if (perfilPessoal == null) {
            throw new NotFound("Não existe perfil pessoal cadastrado para este usuário!");
        }

        String filename = "avatar_" + perfilPessoal.getId() + ".png";
        Path path = rootLocation.resolve(filename);
        Resource resource = new UrlResource(path.toUri());
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG)
                .body(new InputStreamResource(resource.getInputStream()));
    }

    @GetMapping(value = "{id}/perfil/pessoal/qrcode", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<InputStreamResource> getQRCodePerfilPessoal(@PathVariable(name = "id") String id) throws NotFound, WriterException, IOException {
        Usuario usuario = this.usuarioService.findById(id);
        if (usuario == null) {
            throw new NotFound("Não existe usuário com este id!");
        }

        Pessoal perfilPessoal = usuario.getPerfilPessoal();
        if (perfilPessoal == null) {
            throw new NotFound("Não existe perfil pessoal cadastrado para este usuário!");
        }

        String filename = "qrcode_" + perfilPessoal.getId() + ".png";
        Path path = rootLocation.resolve(filename);
        if (!Files.exists(path)) {
            generateQRCodeImage(id, 350, 350, "src/main/resources/image/qrcode_" + perfilPessoal.getId() + ".png");
        }
        Resource resource = new UrlResource(path.toUri());
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG)
                .body(new InputStreamResource(resource.getInputStream()));
    }

    @DeleteMapping(value = "{id}/perfil/pessoal/avatar")
    public ResponseEntity deleteAvatarPerfilPessoal(@PathVariable(name = "id") String id) throws IOException, NotFound {
        Usuario usuario = this.usuarioService.findById(id);
        if (usuario == null) {
            throw new NotFound("Não existe usuário com este id!");
        }

        Pessoal perfilPessoal = usuario.getPerfilPessoal();
        if (perfilPessoal == null) {
            throw new NotFound("Não existe perfil pessoal cadastrado para este usuário!");
        }
        String filename = "avatar_" + perfilPessoal.getId() + ".png";

        Path path = rootLocation.resolve(filename);
        Files.deleteIfExists(path);
        return ResponseEntity.status(HttpStatus.OK).body("avatar do perfil pessoal removido");
    }

    @GetMapping(value = "/pessoal")
    public ResponseEntity<Pessoal> findPerfilPessoal() {
        Pessoal perfil = usuarioService.find().getPerfilPessoal();
        return ResponseEntity.ok().body(perfil);
    }

    @GetMapping
    public ResponseEntity<Usuario> find() {
        Usuario user = usuarioService.find();
        return ResponseEntity.ok().body(user);
    }
}
