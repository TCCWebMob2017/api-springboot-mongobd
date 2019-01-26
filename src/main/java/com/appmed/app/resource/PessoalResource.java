package com.appmed.app.resource;

import static com.appmed.app.util.ApiVersionUtil.*;
import static com.appmed.app.util.QRCodeReader.*;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.appmed.app.domain.Pessoal;
import com.appmed.app.exceptions.NotFound;
import com.appmed.app.service.InstitucionalService;
import com.appmed.app.service.PessoalService;
import com.google.zxing.WriterException;
import java.io.File;
import java.io.IOException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;

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
    public ResponseEntity<List<Pessoal>> getAllPerfisPessoais() {

        return ResponseEntity.status(HttpStatus.OK)
                .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                .body(this.pessoalService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Pessoal> getPerfilPessoalById(@PathVariable(name = "id") String id) throws NotFound {

        Pessoal pessoal = this.pessoalService.findById(id);

        if (pessoal == null) {
            throw new NotFound("There is no profile with this id!");
        }

        /*
        Pessoal perfilPaciente = pessoal;
        
        Perfil visitanteLogado = null;
        if (perfilPaciente.getPrivacidade().equals(Visibilidade.PUBLICO))   {
            return perfilPaciente;
        } else if (visitanteLogado && perfilPaciente.getPrivacidade().equals(Visibilidade.USUARIOS_APLICATIVO)   {
            return perfilPaciente;
        } else if (visitanteLogado.equals(perfilPaciente)) {
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
        return ResponseEntity.status(HttpStatus.OK)
                .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                .body(pessoal);
    }

    @PostMapping
    public ResponseEntity<Pessoal> savePerfilPessoal(@Valid
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
    public ResponseEntity<Pessoal> updatePerfilPessoal(@PathVariable("id") String id,
            @Valid
            @RequestBody Pessoal pessoal
    ) {
        pessoal.setId(id);
        pessoal = this.pessoalService.save(pessoal);
        return ResponseEntity.status(HttpStatus.OK)
                .body(pessoal);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deletePerfilPessoal(@PathVariable String id
    ) {
        this.pessoalService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("perfil pessoal removido");
    }

    @GetMapping(value = "{id}/qrcode", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<InputStreamResource> getQRCode(@PathVariable(name = "id") String id) throws NotFound, IOException {
         try {
            generateQRCodeImage("https://bioup.herokuapp.com/api/v1/pessoal/{id}", 350, 350, "image/qrcode_" + id + ".png");
        } catch (WriterException e) {
            System.out.println("Could not generate QR Code, WriterException :: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Could not generate QR Code, IOException :: " + e.getMessage());
        }
         
//        ClassPathResource imgFile = new ClassPathResource("src/java/image/qrcode_" + id + ".png");
        ClassPathResource imgFile = new ClassPathResource("image/qrcode_" + id + ".png");
        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(new InputStreamResource(imgFile.getInputStream()));
    }

}
