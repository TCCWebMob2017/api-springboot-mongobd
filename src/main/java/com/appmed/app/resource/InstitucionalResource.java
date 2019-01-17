package com.appmed.app.resource;

import com.appmed.app.domain.perfil.instituicional.Funcionario;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.appmed.app.domain.Institucional;
import com.appmed.app.exceptions.NotFound;
import com.appmed.app.service.InstitucionalService;
import static com.appmed.app.util.ApiVersionUtil.PERFILINSTITUCIONAL;
import static com.appmed.app.util.ApiVersionUtil.REST_APP;
import static com.appmed.app.util.ApiVersionUtil.VERSION_V1;

@RestController
@RequestMapping(value = {
    REST_APP + VERSION_V1 + PERFILINSTITUCIONAL
})
public class InstitucionalResource implements Serializable {

    private static final long serialVersionUID = 8817327877150682195L;

    @Autowired
    private InstitucionalService institucionalService;

    @GetMapping("/all")
    public ResponseEntity<List<Institucional>> getAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                .body(this.institucionalService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Institucional> getInstitucionalById(@PathVariable(name = "id") String id) throws NotFound {
        Institucional institucional = this.institucionalService.findById(id);

        if (institucional == null) {
            throw new NotFound("There is no profile with this id!");
        }

        return ResponseEntity.status(HttpStatus.OK)
                .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                .body(institucional);
    }

    @PostMapping
    public ResponseEntity<Institucional> saveInstitucional(@Valid @RequestBody Institucional institucional) {
        institucional = this.institucionalService.save(institucional);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(institucional);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Institucional> updatePerfilInstituicao(@PathVariable("id") String id,
            @Valid @RequestBody Institucional institucional) {
        institucional.setId(id);
        institucional = this.institucionalService.save(institucional);
        return ResponseEntity.status(HttpStatus.OK)
                .body(institucional);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deletePerfilInstituicao(@PathVariable String id) {
        this.institucionalService.delete(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body("perfil institucional removido");
    }

    
    @PostMapping("{id}/funcionario")
    public ResponseEntity<Institucional> addFuncionario(@Valid
            @PathVariable(name = "id") String id, @Valid @RequestBody Funcionario funcionario) throws NotFound {
        Institucional institucional = this.institucionalService.findById(id);

        if (institucional == null) {
            throw new NotFound("There is no profile with this id!");
        }

        institucional.addFuncionario(funcionario);

        institucional = this.institucionalService.save(institucional);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(institucional);
    }

    @GetMapping("{id}/funcionario")
    public ResponseEntity<List<Funcionario>> getAllFuncionario(@Valid @PathVariable(name = "id") String id) throws NotFound {
        Institucional institucional = this.institucionalService.findById(id);

        if (institucional == null) {
            throw new NotFound("There is no profile with this id!");
        }

        return ResponseEntity.status(HttpStatus.OK)
                .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                .body(institucional.getFuncionarios());
    }

    
    @GetMapping("/usercreator/{id}")
    public ResponseEntity<List<Institucional>> getPerfilInstitucional(
            @Valid @PathVariable(name = "id") String idUsuario) {
        List<Institucional> institucional = (List<Institucional>) this.institucionalService.findByCreatorUser(idUsuario);
        return ResponseEntity.status(HttpStatus.OK)
                .body(institucional);
    }

}
