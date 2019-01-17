package com.appmed.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.appmed.app.domain.Category;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {

}
