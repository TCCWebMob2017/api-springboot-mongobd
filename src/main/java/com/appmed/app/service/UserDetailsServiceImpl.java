package com.appmed.app.service;

import com.appmed.app.domain.Usuario;
import com.appmed.app.repository.UsuarioRepository;
import com.appmed.app.security.UserSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UsuarioRepository usuariosRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario e = this.usuariosRepository.findByEmail(email);
        if (e == null) {
            throw new UsernameNotFoundException(email);
        }
        return new UserSS(e);
        
    }

}
