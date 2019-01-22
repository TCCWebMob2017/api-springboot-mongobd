/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appmed.app.service;

import com.appmed.app.domain.perfil.Alergia;
import com.appmed.app.repository.AlergiaRepository;
import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlergiaService implements Serializable {

    private static final long serialVersionUID = -6539811239928176414L;


    @Autowired
    private AlergiaRepository alergiaRepository;

    public Alergia save(Alergia alergia) {
        return this.alergiaRepository.save(alergia);
    }

    public Alergia findById(String id) {
        return this.alergiaRepository.findOne(id);
    }

    public List<Alergia> findAll() {
        return this.alergiaRepository.findAll();
    }

    public Iterable<Alergia> findByCreatorUser(String idUsuario) {
        return this.alergiaRepository.findByCreatorUser(idUsuario);
    }

    public void delete(String id) {
        this.alergiaRepository.delete(id);
    }
}
