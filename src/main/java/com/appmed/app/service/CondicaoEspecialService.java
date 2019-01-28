package com.appmed.app.service;

import com.appmed.app.domain.CondicaoEspecial;
import com.appmed.app.repository.CondicaoEspecialRepository;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CondicaoEspecialService implements Serializable {

    private static final long serialVersionUID = -8267910475646562431L;

    @Autowired
    private CondicaoEspecialRepository condicaoEspecialRepository;

    public CondicaoEspecial save(CondicaoEspecial condicaoEspecial) {
        return this.condicaoEspecialRepository.save(condicaoEspecial);
    }

    public CondicaoEspecial findById(String id) {
        return this.condicaoEspecialRepository.findOne(id);
    }

    public List<CondicaoEspecial> findAll() {
        return this.condicaoEspecialRepository.findAll();
    }

  //  public List<CondicaoEspecial> findByCreatorUser(String idUsuario) {
  //      return this.condicaoEspecialRepository.findByCreatedByUser(idUsuario);
  //  }

    public void delete(String id) {
        this.condicaoEspecialRepository.delete(id);
    }
}
