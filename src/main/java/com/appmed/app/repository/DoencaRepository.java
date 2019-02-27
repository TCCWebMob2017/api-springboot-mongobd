package com.appmed.app.repository;

import com.appmed.app.domain.Doenca;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface DoencaRepository extends MongoRepository<Doenca, String> {

    @Transactional(readOnly = true)
    @Query("{$or:[{'nome':  {\"$regex\" : ?0 }}, {'nomesPopulares':{\"$regex\" : ?0 }}]}")
    public List<Doenca> findByNome(String nome);

    //public List<Doenca> findByCreatedByUser(String id);
}
