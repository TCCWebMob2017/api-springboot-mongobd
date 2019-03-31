package com.appmed.app.domain;

import java.io.Serializable;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usuario")
public class UsuarioDTO extends AbstractDocument implements Serializable {

    private static final long serialVersionUID = 324595168096077366L;

    private String nome;
    private String email;
    private String tefefone;

    public UsuarioDTO() {
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTefefone() {
        return tefefone;
    }
}
