package com.appmed.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.appmed.app.domain.Usuario;
import org.springframework.data.mongodb.repository.Query;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {

    @Query("{'nome': ?0}")
    public  Iterable<Usuario>  findByNome(String nome);

    @Query("{$and:[{'email': ?0}, {'password': ?1}]}")
    public  Usuario authenticate(String nome, String password);
}
