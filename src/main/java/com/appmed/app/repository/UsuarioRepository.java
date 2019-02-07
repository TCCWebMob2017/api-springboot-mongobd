package com.appmed.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.appmed.app.domain.Usuario;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {

    @Query("{'nome': ?0}")
    public  Iterable<Usuario>  findByNome(String nome);
    
    @Transactional(readOnly=true)
    public Usuario findByEmail(String email);

}
