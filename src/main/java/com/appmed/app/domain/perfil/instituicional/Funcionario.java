package com.appmed.app.domain.perfil.instituicional;

import com.appmed.app.domain.Profissional;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class Funcionario {

    @DBRef
    private Profissional perfilProfissional;
    private Nivel privilegio;
    private String cargo;

    public Funcionario(Profissional perfilProfissional, Nivel privilegio, String cargo) {
        this.perfilProfissional = perfilProfissional;
        this.privilegio = privilegio;
        this.cargo = cargo;
    }

    public Profissional getPerfilProfissional() {
        return perfilProfissional;
    }

    public void setPerfilProfissional(Profissional perfilProfissional) {
        this.perfilProfissional = perfilProfissional;
    }

    public Nivel getPrivilegio() {
        return privilegio;
    }

    public void setPrivilegio(Nivel privilegio) {
        this.privilegio = privilegio;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public enum Nivel {
        GERENTE, SUPERVISOR, OPERADOR;
    }
}
