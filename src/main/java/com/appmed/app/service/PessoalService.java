package com.appmed.app.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appmed.app.domain.Pessoal;
import com.appmed.app.repository.PessoalRepository;

@Service
public class PessoalService implements Serializable {

    private static final long serialVersionUID = 8639676514880417752L;

    @Autowired
    private PessoalRepository pessoalRepository;

    public Pessoal save(Pessoal pessoal) {
        return this.pessoalRepository.save(pessoal);
    }

    public Pessoal findById(String id) {
        return this.pessoalRepository.findOne(id);
    }

    public List<Pessoal> findAll() {
        return this.pessoalRepository.findAll();
    }

   // public Iterable<Pessoal> findByCreatorUser(String idUsuario) {
   //     return this.pessoalRepository.findByCreatorUser(idUsuario);
   // }

    public void delete(String id) {
        this.pessoalRepository.delete(id);
    }
}
