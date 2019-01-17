package com.appmed.app.resource;

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
import com.appmed.app.service.PessoalService;
import com.appmed.app.service.UsuarioService;

@RestController
@RequestMapping(value = {
    REST_APP + VERSION_V1 + USUARIO
})
public class UsuarioResource implements Serializable {

    private static final long serialVersionUID = -2827532105824714138L;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PessoalService pessoalService;

    @GetMapping("/all")
    public ResponseEntity<List<Usuario>> getAll() {
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
        usuario = this.usuarioService.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(usuario);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable("id") String id, @Valid @RequestBody Usuario usuario) {
        usuario.setId(id);
        usuario = this.usuarioService.save(usuario);
        return ResponseEntity.status(HttpStatus.OK)
                .body(usuario);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteUsuario(@PathVariable String id) {
        this.usuarioService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Usuario removido");
    }
}
