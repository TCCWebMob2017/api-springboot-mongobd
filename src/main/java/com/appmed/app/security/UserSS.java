package com.appmed.app.security;

import com.appmed.app.domain.Usuario;
import com.appmed.app.domain.enums.TipoUsuario;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserSS implements UserDetails {

    private static final long serialVersionUID = -7731386583667288943L;
    private String id;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public UserSS() {
    }

    public UserSS(Usuario user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.authorities = user.getTipos().stream().map(x
                -> new SimpleGrantedAuthority(x.getDescricao())).collect(Collectors.toList());
    }

    public String getId() {
        return id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public boolean hasRole(TipoUsuario tipo) {
        return getAuthorities().contains(new SimpleGrantedAuthority(tipo.getDescricao()));
    }

}
