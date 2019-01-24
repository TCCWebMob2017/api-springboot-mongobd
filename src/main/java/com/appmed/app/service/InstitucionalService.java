package com.appmed.app.service;

import com.appmed.app.domain.Institucional;
import com.appmed.app.domain.perfil.instituicional.Funcionario;
import com.appmed.app.repository.InstitucionalRepository;
import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstitucionalService implements Serializable {

    private static final long serialVersionUID = 2715001568356141956L;

    @Autowired
    private InstitucionalRepository institucionalRepository;

    public Institucional save(Institucional institucional) {
        return this.institucionalRepository.save(institucional);
    }

    public Institucional findById(String id) {
        return this.institucionalRepository.findOne(id);
    }

    public List<Institucional> findAll() {
        return this.institucionalRepository.findAll();
    }

    public List<Institucional> findByCreatorUser(String idUsuario) {
        return this.institucionalRepository.findByCreatorUser(idUsuario);
    }

    public void delete(String id) {
        this.institucionalRepository.delete(id);
    }
    
    public List<Funcionario> findAllFuncionarios() {
        return this.institucionalRepository.findFuncionarios();
    }

}
