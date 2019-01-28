package com.appmed.app.resource;

import com.appmed.app.domain.Alergia;
import static com.appmed.app.util.ApiVersionUtil.*;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.appmed.app.exceptions.NotFound;
import com.appmed.app.service.AlergiaService;

@RestController
@RequestMapping(value = { REST_APP + VERSION_V1 + ALERGIA })
public class AlergiaResource implements Serializable {

	private static final long serialVersionUID = -4599178265765319851L;

	@Autowired
	private AlergiaService alergiaService;

	@GetMapping("/all")
	public ResponseEntity<List<Alergia>> getAllAlegias() {
		return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
				.body(this.alergiaService.findAll());
	}

	@GetMapping("{id}")
	public ResponseEntity<Alergia> getAlergiaById(@PathVariable(name = "id") String id) throws NotFound {
		Alergia alergia = this.alergiaService.findById(id);

		if (alergia == null) {
			throw new NotFound("There is no profile with this id!");
		}

		return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
				.body(alergia);
	}

	@PostMapping
	public ResponseEntity<Alergia> saveAlergia(@Valid @RequestBody Alergia alergia) {
		alergia = this.alergiaService.save(alergia);
		return ResponseEntity.status(HttpStatus.CREATED).body(alergia);
	}

	/*
	 * @GetMapping("/usercreator/{id}") public ResponseEntity<List<Alergia>>
	 * getAlergiaByUserCreator(@Valid @PathVariable(name = "id") String idUsuario) {
	 * List<Alergia> alergia = (List<Alergia>)
	 * this.alergiaService.findByCreatorUser(idUsuario); return
	 * ResponseEntity.status(HttpStatus.OK) .body(alergia); }
	 */

	@PutMapping(value = "/{id}")
	public ResponseEntity<Alergia> updateAlergia(@PathVariable("id") String id, @Valid @RequestBody Alergia alergia) {
		alergia.setId(id);
		alergia = this.alergiaService.save(alergia);
		return ResponseEntity.status(HttpStatus.OK).body(alergia);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deleteAlergia(@PathVariable String id) {
		this.alergiaService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body("alergia removida da base de dados");
	}
}
