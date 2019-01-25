
package com.appmed.app.service;

import com.appmed.app.domain.perfil.Droga;
import com.appmed.app.repository.DrogaRepository;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class  DrogaService implements Serializable {
    
    private static final long serialVersionUID = -4575317762291324929L;
        @Autowired
    private DrogaRepository drogaRepository;
        public Droga save(Droga droga) {
        return this.drogaRepository.save(droga);
    }

    public Droga findById(String id) {
        return this.drogaRepository.findOne(id);
    }

    public List<Droga> findAll() {
        return this.drogaRepository.findAll();
    }

 //   public List<Droga> findByCreatorUser(String idUsuario) {
 //       return this.drogaRepository.findByCreatedByUser(idUsuario);
 //   }

    public void delete(String id) {
        this.drogaRepository.delete(id);
    }
    
}
