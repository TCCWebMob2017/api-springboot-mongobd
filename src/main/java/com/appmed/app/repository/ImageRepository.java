package com.appmed.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.appmed.app.domain.Image;

@Repository
public interface ImageRepository extends MongoRepository<Image, String> {

}
