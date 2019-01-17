package com.appmed.app.repository;

import com.appmed.app.domain.Profissional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfissionalRepository extends MongoRepository<Profissional, String> {

}
