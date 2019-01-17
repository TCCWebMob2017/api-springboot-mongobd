
package com.appmed.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.appmed.app.domain.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String>{
    Usuario findByEmail(String email);
}
