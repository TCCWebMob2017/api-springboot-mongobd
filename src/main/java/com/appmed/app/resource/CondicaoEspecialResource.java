package com.appmed.app.resource;

import com.appmed.app.domain.perfil.CondicaoEspecial;
import com.appmed.app.exceptions.NotFound;
import com.appmed.app.service.CondicaoEspecialService;
import static com.appmed.app.util.ApiVersionUtil.CONDICAOESPECIAL;
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
    REST_APP + VERSION_V1 + CONDICAOESPECIAL
})
public class CondicaoEspecialResource implements Serializable {

    private static final long serialVersionUID = 6267820192352340372L;

    @Autowired
    private CondicaoEspecialService condicaoEspecialService;

    @GetMapping("/all")
    public ResponseEntity<List<CondicaoEspecial>> getAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                .body(this.condicaoEspecialService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<CondicaoEspecial> getCondicaoEspecialById(@PathVariable(name = "id") String id) throws NotFound {
        CondicaoEspecial condicaoEspecial = this.condicaoEspecialService.findById(id);

        if (condicaoEspecial == null) {
            throw new NotFound("Não existe condicao especial com este id!");
        }

        return ResponseEntity.status(HttpStatus.OK)
                .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                .body(condicaoEspecial);
    }

    @PostMapping
    public ResponseEntity<CondicaoEspecial> saveCondicaoEspecial(@Valid @RequestBody CondicaoEspecial condicaoEspecial) {
        condicaoEspecial = this.condicaoEspecialService.save(condicaoEspecial);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(condicaoEspecial);
    }

    @GetMapping("/usercreator/{id}")
    public ResponseEntity<List<CondicaoEspecial>> getCondicaoEspecialByUserCreator(@Valid @PathVariable(name = "id") String idUsuario) {
        List<CondicaoEspecial> condicaoEspecial = (List<CondicaoEspecial>) this.condicaoEspecialService.findByCreatorUser(idUsuario);
        return ResponseEntity.status(HttpStatus.OK)
                .body(condicaoEspecial);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CondicaoEspecial> updateCondicaoEspecial(@PathVariable("id") String id, @Valid @RequestBody CondicaoEspecial condicaoEspecial) {
        condicaoEspecial.setId(id);
        condicaoEspecial = this.condicaoEspecialService.save(condicaoEspecial);
        return ResponseEntity.status(HttpStatus.OK)
                .body(condicaoEspecial);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteCondicaoEspecial(@PathVariable String id) {
        this.condicaoEspecialService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Condicao Especial removida da base de dados");
    }

}
