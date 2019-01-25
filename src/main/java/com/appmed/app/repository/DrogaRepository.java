package com.appmed.app.repository;

import com.appmed.app.domain.perfil.Droga;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrogaRepository extends MongoRepository<Droga, String> {

    public List<Droga> findByNome(String nome);

    //public List<Droga> findByCreatedByUser(String id);
}
