package com.appmed.app.resource;

import com.appmed.app.domain.Contato;
import com.appmed.app.exceptions.NotFound;
import com.appmed.app.service.ContatoService;
import static com.appmed.app.util.ApiVersionUtil.CONTATO;
import static com.appmed.app.util.ApiVersionUtil.REST_APP;
import static com.appmed.app.util.ApiVersionUtil.VERSION_V1;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {
    REST_APP + VERSION_V1 + CONTATO
})
public class ContatoResource implements Serializable {

    private static final long serialVersionUID = -1109618247198046920L;
    @Autowired
    private ContatoService contatoService;

    @GetMapping("/all")
    public ResponseEntity<List<Contato>> getAllContatos() {
        return ResponseEntity.status(HttpStatus.OK)
                .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                .body(this.contatoService.findAll());
    }


    @GetMapping("{id}")
    public ResponseEntity<Contato> getContatoById(@PathVariable(name = "id") String id) throws NotFound {
        Contato dontato = this.contatoService.findById(id);

        if (dontato == null) {
            throw new NotFound("Não existe contato com este id!");
        }

        return ResponseEntity.status(HttpStatus.OK)
                .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                .body(dontato);
    }

    @PostMapping
    public ResponseEntity<Contato> saveContato(@Valid @RequestBody Contato contato) {
        contato = this.contatoService.save(contato);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(contato);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Contato> updateContato(@PathVariable("id") String id,
            @Valid @RequestBody Contato contato) {
        contato.setId(id);
        contato = this.contatoService.save(contato);
        return ResponseEntity.status(HttpStatus.OK)
                .body(contato);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteContato(@PathVariable String id) {
        this.contatoService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("contato removida da base de dados");
    }
}
