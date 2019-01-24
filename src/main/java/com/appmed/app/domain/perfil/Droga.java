package com.appmed.app.domain.perfil;

import com.appmed.app.domain.AbstractEntityNetwork;
import com.appmed.app.domain.Usuario;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "droga")
public class Droga  extends AbstractEntityNetwork implements Serializable {

    private static final long serialVersionUID = -1864316185741771641L;
    
    private String nome;
    private List<String> nomePopular;//apelidos, similares
    private String descricao;
    private String efeitos;
    private String consequenciasNegativas;

    public Droga() {
        super();
    }
    public Droga(String nome) {
        super();
        this.nome = nome;
    }
    
    public Droga(String nome, Usuario createdByUser) {
        super(createdByUser);
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEfeitos() {
        return efeitos;
    }

    public void setEfeitos(String efeitos) {
        this.efeitos = efeitos;
    }

    public String getConsequenciasNegativas() {
        return consequenciasNegativas;
    }

    public void setConsequenciasNegativas(String consequenciasNegativas) {
        this.consequenciasNegativas = consequenciasNegativas;
    }

    public List<String> getNomePopular() {
        return nomePopular;
    }

    public void setNomePopular(List<String> nomePopular) {
        this.nomePopular = nomePopular;
    }
    
    
}
