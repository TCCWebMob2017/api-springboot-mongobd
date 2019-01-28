
package com.appmed.app.repository;

import com.appmed.app.domain.Medicamento;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicamentoRepository extends MongoRepository<Medicamento, String> {

    public List<Medicamento> findByNome(String nome);

   // public List<Medicamento> findByCreatedByUser(String id);
}
