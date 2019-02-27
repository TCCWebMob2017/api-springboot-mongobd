
package com.appmed.app.repository;

import com.appmed.app.domain.Medicamento;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface MedicamentoRepository extends MongoRepository<Medicamento, String> {
    @Transactional(readOnly=true)
    @Query("{$or:[{'nome':  {\"$regex\" : ?0 , $options: 'i'}}, {'principioAtivo':{\"$regex\" : ?0 , $options: 'i'}}]}")
    public List<Medicamento> findByNome(String nome);

   // public List<Medicamento> findByCreatedByUser(String id);
}
