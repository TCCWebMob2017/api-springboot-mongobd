
package com.appmed.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.appmed.app.domain.Pessoal;
import org.springframework.data.mongodb.repository.Query;

@Repository
public interface PessoalRepository extends MongoRepository<Pessoal, String>{
   // @Query("{'createdBy.$id': ?0}")
   // public Iterable<Pessoal> findByCreatorUser(String createdBy);
    
   // @Query("{$and:[{'createdBy.$id': ?0}, {'tipoPerfil':'PESSOAL'}]}")
   // public Iterable<Pessoal> findByUser(String createdBy);
    
    @Query("{'cpf': ?0}")
    public Pessoal findByCPF(String cpf);
    
    @Query("{'nome': ?0}")
    public Iterable<Pessoal> findByNome(String cpf);
    
   

}
