package com.appmed.app.service;

import com.appmed.app.domain.perfil.Medicamento;
import com.appmed.app.repository.InstitucionalRepository;
import com.appmed.app.repository.MedicamentoRepository;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicamentoService implements Serializable {

    private static final long serialVersionUID = 2962168249669503271L;

    @Autowired
    private MedicamentoRepository medicamentoRepository;

    public Medicamento save(Medicamento medicamento) {
        return this.medicamentoRepository.save(medicamento);
    }

    public Medicamento findById(String id) {
        return this.medicamentoRepository.findOne(id);
    }

    public List<Medicamento> findAll() {
        return this.medicamentoRepository.findAll();
    }

  //  public List<Medicamento> findByCreatorUser(String idUsuario) {
  //      return this.medicamentoRepository.findByCreatedByUser(idUsuario);
  //  }

    public void delete(String id) {
        this.medicamentoRepository.delete(id);
    }
}
