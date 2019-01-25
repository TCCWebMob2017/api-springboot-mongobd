package com.appmed.app.repository;

import com.appmed.app.domain.perfil.CondicaoEspecial;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CondicaoEspecialRepository extends MongoRepository<CondicaoEspecial, String> {

    public List<CondicaoEspecial> findByNome(String nome);

   // public List<CondicaoEspecial> findByCreatedByUser(String id);

}
