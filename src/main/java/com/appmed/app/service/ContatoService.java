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
        return this.contatoRepository.findByNomeAmigoPaciente(nome);
    }

    public List<Contato> findByCreatorUser(String nome) {
        return this.contatoRepository.findByNomePaciente(nome);
    }

    public void delete(String id) {
        this.contatoRepository.delete(id);
    }
}
