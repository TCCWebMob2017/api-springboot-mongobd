package com.appmed.app.repository;

import com.appmed.app.domain.Droga;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface DrogaRepository extends MongoRepository<Droga, String> {
    @Transactional(readOnly=true)
    @Query("{$or:[{'nome':  {\"$regex\" : ?0 , $options: 'i'}}, {'nomePopular':{\"$regex\" : ?0 , $options: 'i'}}]}")
    public List<Droga> findByNome(String nome);

    //public List<Droga> findByCreatedByUser(String id);
}
