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
    @Query("{$or:[{'nome':  {\"$regex\" : ?0 }}, {'contato.$nome':{\"$regex\" : ?0 }}]}")
    public List<Contato> findByNomeContato(String nome);

    @Transactional(readOnly = true)
    @Query("{'paciente.$nome':{\"$regex\" : ?0 }}")
    public List<Contato> findByNomePaciente(String nome);

    @Transactional(readOnly = true)
    @Query("{'paciente.$id': ?0 }")
    public List<Contato> findByIdPaciente(String id);

    @Transactional(readOnly = true)
    @Query("{'contato.$id': ?0 }")
    public List<Contato> findByIdContato(String id);

    @Transactional(readOnly = true)
    @Query("{$and:[{'contato.$id':  ?0 }, {'nivelPermissao': '1' }]}")
    public List<Contato> getPossoVer(String idVisitante);

    @Transactional(readOnly = true)
    @Query("{$and:[{'contato.$id':  ?0 }, {'nivelPermissao': '2' }]}")
    public List<Contato> getPossoEditar(String idVisitante);

    @Transactional(readOnly = true)
    @Query("{$and:[{'paciente.$id':  ?0 }, {'nivelPermissao': '1' }]}")
    public List<Contato> getPodemVer(String idVisitante);

    @Transactional(readOnly = true)
    @Query("{$and:[{'paciente.$id':  ?0 }, {'nivelPermissao': '2' }]}")
    public List<Contato> getPodemEditar(String idVisitante);
   
}
