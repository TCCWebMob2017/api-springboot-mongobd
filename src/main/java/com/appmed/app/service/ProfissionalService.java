package com.appmed.app.service;

import com.appmed.app.domain.Profissional;
import com.appmed.app.repository.ProfissionalRepository;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfissionalService implements Serializable {

    private static final long serialVersionUID = -3452859355201384702L;

	@Autowired
	private ProfissionalRepository profissionalRepository;
	
	public Profissional save(Profissional profissional) {
		return this.profissionalRepository.save(profissional);
	}
	
	public Profissional findById(String id) {
		return this.profissionalRepository.findOne(id);
	}
	
	public List<Profissional> findAll() {
		return this.profissionalRepository.findAll();
	}
        
        public void delete(String id){
         this.profissionalRepository.delete(id);
        }
        
}