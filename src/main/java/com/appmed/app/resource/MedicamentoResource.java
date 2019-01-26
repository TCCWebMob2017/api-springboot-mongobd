package com.appmed.app.resource;

import com.appmed.app.domain.perfil.Medicamento;
import com.appmed.app.exceptions.NotFound;
import com.appmed.app.service.MedicamentoService;
import static com.appmed.app.util.ApiVersionUtil.MEDICAMENTO;
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
    REST_APP + VERSION_V1 + MEDICAMENTO
})
public class MedicamentoResource implements Serializable {

    private static final long serialVersionUID = 5045458477382988334L;


    @Autowired
    private MedicamentoService medicamentoService;

    @GetMapping("/all")
    public ResponseEntity<List<Medicamento>> getAllMedicamentos() {
        return ResponseEntity.status(HttpStatus.OK)
                .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                .body(this.medicamentoService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Medicamento> getMedicamentoById(@PathVariable(name = "id") String id) throws NotFound {
        Medicamento medicamento = this.medicamentoService.findById(id);

        if (medicamento == null) {
            throw new NotFound("Não existe medicamento com este id!");
        }

        return ResponseEntity.status(HttpStatus.OK)
                .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                .body(medicamento);
    }

    @PostMapping
    public ResponseEntity<Medicamento> saveMedicamento(@Valid @RequestBody Medicamento medicamento) {
        medicamento = this.medicamentoService.save(medicamento);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(medicamento);
    }
/*
    @GetMapping("/usercreator/{id}")
    public ResponseEntity<List<Medicamento>> getMedicamentoByUserCreator(@Valid @PathVariable(name = "id") String idUsuario) {
        List<Medicamento> medicamento = (List<Medicamento>) this.medicamentoService.findByCreatorUser(idUsuario);
        return ResponseEntity.status(HttpStatus.OK)
                .body(medicamento);
    }
*/
    @PutMapping(value = "/{id}")
    public ResponseEntity<Medicamento> updateMedicamento(@PathVariable("id") String id, @Valid @RequestBody Medicamento medicamento) {
        medicamento.setId(id);
        medicamento = this.medicamentoService.save(medicamento);
        return ResponseEntity.status(HttpStatus.OK)
                .body(medicamento);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteMedicamento(@PathVariable String id) {
        this.medicamentoService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Medicamento removido da base de dados");
    }

}
