package com.appmed.app.repository;

import com.appmed.app.domain.Pessoal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.appmed.app.domain.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    @Transactional(readOnly=true)
    @Query("{'nome': ?0}")
    public  Iterable<Usuario>  findByNome(String nome);
    
    @Transactional(readOnly=true)
    @Query("{'email': ?0}")
    public Usuario findByEmail(String email);
    
    @Transactional(readOnly = true)
    public Page<Usuario> findById(Usuario usuario, Pageable pageRequest);

}
