package com.appmed.app.repository;

import com.appmed.app.domain.Doenca;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoencaRepository extends MongoRepository<Doenca, String> {

    public List<Doenca> findByNome(String nome);

    //public List<Doenca> findByCreatedByUser(String id);
}
