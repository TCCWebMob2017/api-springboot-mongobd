package com.appmed.app.resource;

import com.appmed.app.domain.perfil.Doenca;
import static com.appmed.app.util.ApiVersionUtil.*;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.appmed.app.exceptions.NotFound;
import com.appmed.app.service.DoencaService;

@RestController
@RequestMapping(value = {
    REST_APP + VERSION_V1 + DOENCA
})
public class DoencaResource implements Serializable {

    private static final long serialVersionUID = -8451736073795774514L;

    @Autowired
    private DoencaService doencaService;

    @GetMapping("/all")
    public ResponseEntity<List<Doenca>> getAllDoencas() {
        return ResponseEntity.status(HttpStatus.OK)
                .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                .body(this.doencaService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Doenca> getDoencaById(@PathVariable(name = "id") String id) throws NotFound {
        Doenca doenca = this.doencaService.findById(id);

        if (doenca == null) {
            throw new NotFound("Não existe doença com este id!");
        }

        return ResponseEntity.status(HttpStatus.OK)
                .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                .body(doenca);
    }

    @PostMapping
    public ResponseEntity<Doenca> saveDoenca(@Valid @RequestBody Doenca doenca) {
        doenca = this.doencaService.save(doenca);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(doenca);
    }
/*
    @GetMapping("/usercreator/{id}")
    public ResponseEntity<List<Doenca>> getDoencaByUserCreator(@Valid @PathVariable(name = "id") String idUsuario) {
        List<Doenca> doenca = (List<Doenca>) this.doencaService.findByCreatorUser(idUsuario);
        return ResponseEntity.status(HttpStatus.OK)
                .body(doenca);
    }
*/
    @PutMapping(value = "/{id}")
    public ResponseEntity<Doenca> updateDoenca(@PathVariable("id") String id, @Valid @RequestBody Doenca doenca) {
        doenca.setId(id);
        doenca = this.doencaService.save(doenca);
        return ResponseEntity.status(HttpStatus.OK)
                .body(doenca);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteDoenca(@PathVariable String id) {
        this.doencaService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("doenca removida da base de dados");
    }
}
