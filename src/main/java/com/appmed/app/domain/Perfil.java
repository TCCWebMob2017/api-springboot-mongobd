package com.appmed.app.domain;

public class Perfil extends AbstractEntityNetwork {

    private String nome;
    private TipoPerfil tipoPerfil;

    public Perfil() {
        super();
    }

    public Perfil(Usuario createdBy) {
        super(createdBy);
    }

    public Perfil(Usuario createdBy, TipoPerfil tipoPerfil) {
        super(createdBy);
        this.tipoPerfil = tipoPerfil;

    }

    public Perfil(Usuario createdBy, TipoPerfil tipoPerfil, String nome) {
        super(createdBy);
        this.nome = nome;
        this.tipoPerfil = tipoPerfil;
    }

    public enum TipoPerfil {
        PESSOAL, PROFISSIONAL, ORGANIZACAO, DEPENDENTE;
    }

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoPerfil getTipoPerfil() {
        return tipoPerfil;
    }

    public void setTipoPerfil(TipoPerfil tipoPerfil) {
        this.tipoPerfil = tipoPerfil;
    }

    
    
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Perfil other = (Perfil) obj;
        if (getId() == null) {
            if (other.getId() != null) {
                return false;
            }
        } else if (!getId().equals(other.getId())) {
            return false;
        }
        return true;
    }
}
