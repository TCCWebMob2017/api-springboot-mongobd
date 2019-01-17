package com.appmed.app.domain.perfil;

import com.appmed.app.domain.AbstractEntityNetwork;
import com.appmed.app.domain.Usuario;
import java.io.Serializable;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "droga")
public class Droga  extends AbstractEntityNetwork implements Serializable {

    private static final long serialVersionUID = -1864316185741771641L;
    
    private String nome;
    private String outrosNomes;//apelidos, similares
    
    public Droga(String nome, Usuario createdByUser) {
        super(createdByUser);
        this.nome = nome;
    }

    public Droga(String nome, String outrosNomes, Usuario createdByUser) {
        super(createdByUser);
        this.nome = nome;
        this.outrosNomes = outrosNomes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getOutrosNomes() {
        return outrosNomes;
    }

    public void setOutrosNomes(String outrosNomes) {
        this.outrosNomes = outrosNomes;
    }
    
    
}
