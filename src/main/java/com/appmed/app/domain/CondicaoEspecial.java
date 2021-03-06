package com.appmed.app.domain;

import com.appmed.app.domain.AbstractEntityNetwork;
import com.appmed.app.domain.Usuario;
import java.io.Serializable;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "condicaoespecial")
public class CondicaoEspecial  extends AbstractEntityNetwork implements Serializable {

    private static final long serialVersionUID = 2667988402856702030L;
    
    private String nome;

    public CondicaoEspecial() {
    }

    
    public CondicaoEspecial(String nome) {
        super();
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
