
package com.appmed.app.service;

import com.appmed.app.domain.Doenca;
import com.appmed.app.repository.DoencaRepository;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoencaService implements Serializable {

    private static final long serialVersionUID = 6507820766743825875L;

    @Autowired
    private DoencaRepository doencaRepository;

    public Doenca save(Doenca doenca) {
        return this.doencaRepository.save(doenca);
    }

    public Doenca findById(String id) {
        return this.doencaRepository.findOne(id);
    }

    public List<Doenca> findAll() {
        return this.doencaRepository.findAll();
    }

     public List<Doenca> findByNome(String nome) {
        return this.doencaRepository.findByNome(nome);
    }
   // public List<Doenca> findByCreatorUser(String idUsuario) {
   //     return this.doencaRepository.findByCreatedByUser(idUsuario);
   // }

    public void delete(String id) {
        this.doencaRepository.delete(id);
    }
}
