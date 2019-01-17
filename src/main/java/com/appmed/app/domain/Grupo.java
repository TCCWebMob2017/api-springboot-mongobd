package com.appmed.app.domain;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "contato")
public class Grupo extends AbstractEntityNetwork implements Serializable {
    
    private static final long serialVersionUID = -7889157093570081838L;
    
    private String nome;
    private Privacidade privacidade;
    @DBRef
    private List<Contato> contado;
    
    
    
    
}
