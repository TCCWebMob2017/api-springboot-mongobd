package com.appmed.app.repository;

import com.appmed.app.domain.Alergia;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AlergiaRepository extends MongoRepository<Alergia, String> {
    //@Query("{'createdBy.$id': ?0}")
    //public Iterable<Alergia> findByCreatorUser(String createdBy);
    
    @Transactional(readOnly=true)
    @Query("{$or:[{'nome':  {\"$regex\" : ?0 , $options: 'i'}},"
            + " {'categoria':{\"$regex\" : ?0 , $options: 'i'}}]}")
    public List<Alergia> findByNome(String nome);

    //public List<Alergia> findByCreatedByUser(String id);
}
