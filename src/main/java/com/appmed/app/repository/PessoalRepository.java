package com.appmed.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.appmed.app.domain.Pessoal;
import com.appmed.app.domain.Usuario;
import org.springframework.data.domain.Page;
 import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PessoalRepository extends MongoRepository<Pessoal, String> {
    // @Query("{'createdBy.$id': ?0}")
    // public Iterable<Pessoal> findByCreatorUser(String createdBy);

    // @Query("{$and:[{'createdBy.$id': ?0}, {'tipoPerfil':'PESSOAL'}]}")
    // public Iterable<Pessoal> findByUser(String createdBy);
    
    @Transactional(readOnly = true)
    Page<Pessoal> findByCreatedByUser(Usuario usuario, Pageable pageRequest);

    @Query("{'cpf': ?0}")
    public Pessoal findByCPF(String cpf);

    @Query("{'telefone': ?0}")
    public Pessoal findByTelefone(String telefone);

    @Query("{'nome': ?0}")
    public Iterable<Pessoal> findByNome(String cpf);

}
