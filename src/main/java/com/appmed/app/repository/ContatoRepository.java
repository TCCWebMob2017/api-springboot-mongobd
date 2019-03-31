package com.appmed.app.repository;

import com.appmed.app.domain.Contato;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ContatoRepository extends MongoRepository<Contato, String> {

    @Transactional(readOnly = true)
    @Query("{$or:[{'nome':  {\"$regex\" : ?0 }}, {'contaContato.$nome':{\"$regex\" : ?0 }}]}")
    public List<Contato> findByNomeAmigoPaciente(String nome);

    @Transactional(readOnly = true)
    @Query("{'contaPaciente.$nome':{\"$regex\" : ?0 }}")
    public List<Contato> findByNomePaciente(String nome);
    
    @Transactional(readOnly = true)
    @Query("{'contaPaciente.$id': ?0 }")
    public List<Contato> findByIdPaciente(String id);
 
    @Transactional(readOnly = true)
    @Query("{'contaContato.$id': ?0 }")
    public List<Contato> findByIdAmigoPaciente(String id);
}
