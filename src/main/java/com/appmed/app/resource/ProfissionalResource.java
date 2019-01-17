package com.appmed.app.resource;

import static com.appmed.app.util.ApiVersionUtil.*;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.appmed.app.domain.Profissional;
import com.appmed.app.exceptions.NotFound;
import com.appmed.app.service.PessoalService;
import com.appmed.app.service.ProfissionalService;

@RestController
@RequestMapping(value = {
    REST_APP + VERSION_V1 + PERFILPROFISSIONAL
})
public class ProfissionalResource implements Serializable {

    private static final long serialVersionUID = 7150383321036241843L;

    @Autowired
    private ProfissionalService profissionalService;

    @Autowired
    private PessoalService pessoalService;

    @GetMapping("/all")
    public ResponseEntity<List<Profissional>> getAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                .body(this.profissionalService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Profissional> getProfissionalById(@PathVariable(name = "id") String id) throws NotFound {
        Profissional profissional = this.profissionalService.findById(id);

        if (profissional == null) {
            throw new NotFound("There is no user with this id!");
        }

        return ResponseEntity.status(HttpStatus.OK)
                .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                .body(profissional);
    }

    @PostMapping
    public ResponseEntity<Profissional> saveProfissional(@Valid @RequestBody Profissional profissional) {
        profissional = this.profissionalService.save(profissional);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(profissional);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Profissional> updateProfissional(@PathVariable("id") String id, @Valid @RequestBody Profissional profissional) {
        profissional.setId(id);
        profissional = this.profissionalService.save(profissional);
        return ResponseEntity.status(HttpStatus.OK)
                .body(profissional);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteProfissional(@PathVariable String id) {
        this.profissionalService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Profissional removido");
    }
}
