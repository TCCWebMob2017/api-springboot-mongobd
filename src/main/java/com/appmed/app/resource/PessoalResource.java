package com.appmed.app.resource;

import com.appmed.app.domain.Perfil;
import com.appmed.app.domain.Perfil.Visibilidade;
import static com.appmed.app.util.ApiVersionUtil.*;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.appmed.app.domain.Pessoal;
import com.appmed.app.domain.Profissional;
import com.appmed.app.exceptions.NotFound;
import com.appmed.app.service.InstitucionalService;
import com.appmed.app.service.PessoalService;

@RestController
@RequestMapping(value = {
    REST_APP + VERSION_V1 + PERFILPESSOAL
})
public class PessoalResource implements Serializable {

    private static final long serialVersionUID = -4599178265765319851L;

    @Autowired
    private PessoalService pessoalService;
    @Autowired
    private InstitucionalService instituicaoService;

    @GetMapping("/all")
    public ResponseEntity<List<Pessoal>> getAll() {

        return ResponseEntity.status(HttpStatus.OK)
                .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                .body(this.pessoalService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Pessoal> getPessoalById(@PathVariable(name = "id") String id) throws NotFound {

        Pessoal pessoal = this.pessoalService.findById(id);

        if (pessoal == null) {
            throw new NotFound("There is no profile with this id!");
        }
        
        /*
        Pessoal perfilPaciente = pessoal;
        
        Perfil visitanteLogado = null;
        if (visitante == null && perfilPaciente.getPrivacidade().equals(Visibilidade.PUBLICO)   {
            return perfilPaciente;
        } else if (visitanteLogado && perfilPaciente.getPrivacidade().equals(Visibilidade.USUARIOS_APLICATIVO)   {
            return perfilPaciente;
        } else if (visitanteLogado.equals(perfilPaciente)) {
            return perfilPaciente;
        } else if (perfilPaciente.getPrivacidade().equals(Visibilidade.PUBLICO)) {
            return perfilPaciente;
        } else if (perfilPaciente.getPrivacidade().equals(Visibilidade.ORGANIZACAO_SAUDE)) {
            if (visitanteLogado.getTipoPerfil().equals(TipoPerfil.PROFISSIONAL)) {
                Profissional visitanteProfissionalLogado = (Profissional) visitanteLogado;
                visitanteProfissionalLogado.getInstituicoesTrabalho().contains(ORGANIZACAO_SAUDE)
                {
                    return perfilPaciente;
                }
            }
        } else if (perfilPaciente.getPrivacidade().equals(Visibilidade.PROFISSIONAIS_SAUDE)) {
            if (visitanteLogado.getTipoPerfil().equals(TipoPerfil.PROFISSIONAL)) {
                Profissional visitanteProfissionalLogado = (Profissional) visitanteLogado;
                visitanteProfissionalLogado.getAreaAtuacao().equals(AreaAtuacao.SAUDE)
                {
                    return perfilPaciente;
                }
            } else if (perfilPaciente.getPrivacidade().equals(Visibilidade.CONTATOS)) {
                if (perfilPaciente.getContatos().contains(visitanteLogado)){
                   //verifica permissão do contato
                   //return perfilPaciente
                }
            }
        }
    }*/

    return ResponseEntity.status (HttpStatus.OK)

.cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                .body(pessoal);
    }

    @PostMapping
        public ResponseEntity<Pessoal> savePessoal(@Valid
        @RequestBody Pessoal pessoal
    ) {
        pessoal = this.pessoalService.save(pessoal);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(pessoal);
    }
/*
    @GetMapping("/usercreator/{id}")
        public ResponseEntity<List<Pessoal>> getPerfilPessoal(@Valid
        @PathVariable(name = "id") String idUsuario
    ) {
        List<Pessoal> pessoal = (List<Pessoal>) this.pessoalService.findByCreatorUser(idUsuario);
        return ResponseEntity.status(HttpStatus.OK)
                .body(pessoal);
    }
*/
    @PutMapping(value = "/{id}")
        public ResponseEntity<Pessoal> updateUsuario(@PathVariable("id") String id,
            @Valid
        @RequestBody Pessoal pessoal
    ) {
        pessoal.setId(id);
        pessoal = this.pessoalService.save(pessoal);
        return ResponseEntity.status(HttpStatus.OK)
                .body(pessoal);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
        public ResponseEntity deleteProfissional(@PathVariable String id
    ) {
        this.pessoalService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("perfil pessoal removido");
    }
}
