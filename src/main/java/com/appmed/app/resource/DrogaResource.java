
package com.appmed.app.resource;

import com.appmed.app.domain.perfil.Droga;
import com.appmed.app.exceptions.NotFound;
import com.appmed.app.service.DrogaService;
import static com.appmed.app.util.ApiVersionUtil.DROGA;
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
    REST_APP + VERSION_V1 + DROGA
})
public class DrogaResource implements Serializable {
    
    private static final long serialVersionUID = 3757330234246068110L;
    
     @Autowired
    private DrogaService drogaService;

    @GetMapping("/all")
    public ResponseEntity<List<Droga>> getAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                .body(this.drogaService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Droga> getDrogaById(@PathVariable(name = "id") String id) throws NotFound {
        Droga droga = this.drogaService.findById(id);

        if (droga == null) {
            throw new NotFound("Não existe droga com este id!");
        }

        return ResponseEntity.status(HttpStatus.OK)
                .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                .body(droga);
    }

    @PostMapping
    public ResponseEntity<Droga> saveDroga(@Valid @RequestBody Droga droga) {
        droga = this.drogaService.save(droga);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(droga);
    }
/*
    @GetMapping("/usercreator/{id}")
    public ResponseEntity<List<Droga>> getDrogaByUserCreator(@Valid @PathVariable(name = "id") String idUsuario) {
        List<Droga> droga = (List<Droga>) this.drogaService.findByCreatorUser(idUsuario);
        return ResponseEntity.status(HttpStatus.OK)
                .body(droga);
    }
*/
    @PutMapping(value = "/{id}")
    public ResponseEntity<Droga> updateDroga(@PathVariable("id") String id, @Valid @RequestBody Droga droga) {
        droga.setId(id);
        droga = this.drogaService.save(droga);
        return ResponseEntity.status(HttpStatus.OK)
                .body(droga);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteDroga(@PathVariable String id) {
        this.drogaService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Droga removida da base de dados");
    }

}
