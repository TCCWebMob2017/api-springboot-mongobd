package com.appmed.app.service;

import com.appmed.app.domain.Contato;
import com.appmed.app.repository.ContatoRepository;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContatoService implements Serializable {

    private static final long serialVersionUID = -242766636280274863L;

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private UsuarioService usuarioService;

    public Contato save(Contato contato) {
        return this.contatoRepository.save(contato);
    }

    public Contato findById(String id) {
        return this.contatoRepository.findOne(id);
    }

    public List<Contato> findAll() {
        return this.contatoRepository.findAll();
    }

    public List<Contato> findByNomeContato(String nome) {
        return this.contatoRepository.findByNomeContato(nome);
    }

    public List<Contato> findByNomePaciente(String nome) {
        return this.contatoRepository.findByNomePaciente(nome);
    }

    public List<Contato> findByIdContato(String id) {
        return this.contatoRepository.findByIdContato(id);
    }

    public List<Contato> findByIdPaciente(String id) {
        return this.contatoRepository.findByIdPaciente(id);
    }

    public List<Contato> getPossoVer(String idVisitante) {
        return this.contatoRepository.getPossoVer(idVisitante);
    }

    public List<Contato> getPossoEditar(String idVisitante) {
        return this.contatoRepository.getPossoEditar(idVisitante);
    }

    public List<Contato> getPodemVer(String idVisitante) {
        return this.contatoRepository.getPodemVer(idVisitante);
    }

    public List<Contato> getPodemEditar(String idVisitante) {
        return this.contatoRepository.getPodemEditar(idVisitante);
    }

    public void delete(String id) {
        this.contatoRepository.delete(id);
    }
}
