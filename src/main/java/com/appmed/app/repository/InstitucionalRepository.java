package com.appmed.app.repository;

import com.appmed.app.domain.Institucional;
import com.appmed.app.domain.perfil.instituicional.Funcionario;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitucionalRepository extends MongoRepository<Institucional, String>{
    @Query("{'createdBy.$id': ?0}")
    public List<Institucional> findByCreatorUser(String createdBy);
    
    @Query("{'cnpj': ?0}")
    public Institucional findByCPF(String cnpj);
    
    @Query("{'nome': ?0}")
    public List<Institucional> findByNome(String nome);
    
    @Query("{'Area': 'SAUDE'}")
    public List<Funcionario> findFuncionarios();
}
