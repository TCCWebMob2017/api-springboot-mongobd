package com.appmed.app.resource;

import static com.appmed.app.util.ApiVersionUtil.*;
import static com.appmed.app.util.QRCodeReader.*;

import java.io.Serializable;
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
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.core.io.InputStreamResource;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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

    @PutMapping(value = "/{id}")
    public ResponseEntity<Pessoal> updatePerfilPessoal(@PathVariable("id") String id,
            @Valid @RequestBody Pessoal pessoal) {
        pessoal.setId(id);
        pessoal = this.pessoalService.save(pessoal);
        return ResponseEntity.status(HttpStatus.OK)
                .body(pessoal);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deletePerfilPessoal(@PathVariable String id) {
        this.pessoalService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("perfil pessoal removido");
    }
    private final Path rootLocation = Paths.get("src/main/resources/image/");

    @PostMapping(value = "{id}/avatar")
    public ResponseEntity<String> saveAvatar(@PathVariable String id, @RequestParam("file") MultipartFile file) throws IOException {
        String filename = "avatar_" + id + ".png";
        Files.copy(file.getInputStream(), this.rootLocation.resolve(filename));
        return ResponseEntity.status(HttpStatus.CREATED).body("imagem salva");
    }

    @PutMapping(value = "{id}/avatar", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<String> updateAvatar(@PathVariable String id, @RequestParam("file") MultipartFile file) throws IOException {
        String filename = "avatar_" + id + ".png";
        Files.copy(file.getInputStream(), this.rootLocation.resolve(filename));
        return ResponseEntity.status(HttpStatus.OK).body("imagem salva");
    }

    @GetMapping(value = "{id}/avatar", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<InputStreamResource> getAvatar(@PathVariable String id) throws IOException {
        String filename = "avatar_" + id + ".png";
        Path path = rootLocation.resolve(filename);
        Resource resource = new UrlResource(path.toUri());
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG)
                .body(new InputStreamResource(resource.getInputStream()));
    }

    @GetMapping(value = "{id}/qrcode", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<InputStreamResource> getQRCode(@PathVariable(name = "id") String id) throws NotFound, WriterException, IOException {
        //Pessoal e = this.pessoalService.findById(id);
        String filename = "qrcode_" + id + ".png";
        Path path = rootLocation.resolve(filename);
        if (!Files.exists(path)) {
            generateQRCodeImage(id, 350, 350, "src/main/resources/image/qrcode_" + id + ".png");
        }
        Resource resource = new UrlResource(path.toUri());
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG)
                .body(new InputStreamResource(resource.getInputStream()));
    }

    @DeleteMapping(value = "{id}/avatar")
    public ResponseEntity deleteAvatar(@PathVariable(name = "id") String id) throws IOException {
        //Pessoal e = this.pessoalService.findById(id);
        String filename = "avatar_" + id + ".png";
        Path path = rootLocation.resolve(filename);
        Files.deleteIfExists(path);
        return ResponseEntity.status(HttpStatus.OK).body("avatar do perfil pessoal removido");
    }

    @GetMapping
    public ResponseEntity<Page<Pessoal>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "instante") String orderBy,
            @RequestParam(value = "direction", defaultValue = "DESC") String direction) {
        Page<Pessoal> list = pessoalService.findPage(page, linesPerPage, orderBy, direction);
        return ResponseEntity.ok().body(list);
    }
}
