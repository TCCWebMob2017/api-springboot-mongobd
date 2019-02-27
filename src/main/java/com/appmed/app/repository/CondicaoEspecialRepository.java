package com.appmed.app.repository;

import com.appmed.app.domain.CondicaoEspecial;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CondicaoEspecialRepository extends MongoRepository<CondicaoEspecial, String> {

    @Transactional(readOnly = true)
    @Query("{$or:[{'nome':  {\"$regex\" : ?0 , $options: 'i'}},"
            + " {'categoria':{\"$regex\" : ?0 , $options: 'i'}}]}")
    public List<CondicaoEspecial> findByNome(String nome);

    // public List<CondicaoEspecial> findByCreatedByUser(String id);
}
