package com.appmed.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.appmed.app.domain.Movie;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String>{

}
