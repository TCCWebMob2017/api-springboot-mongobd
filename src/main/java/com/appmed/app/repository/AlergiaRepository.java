
package com.appmed.app.repository;

import com.appmed.app.domain.perfil.Alergia;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AlergiaRepository extends MongoRepository<Alergia, String> {
    @Query("{'createdBy.$id': ?0}")
    public Iterable<Alergia> findByCreatorUser(String createdBy);
}
