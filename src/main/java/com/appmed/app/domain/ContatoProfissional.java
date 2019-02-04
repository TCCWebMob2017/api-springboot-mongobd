package com.appmed.app.domain;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "contato")
public class ContatoProfissional extends Contato {

    private static final long serialVersionUID = 5398203966914524224L;

    @DBRef
    private Profissional perfiContato;

    public ContatoProfissional(Profissional perfiContato) {
        this.perfiContato = perfiContato;
    }

    public ContatoProfissional(Profissional perfiContato, String relacao, NivelPermissao nivelPermissao) {
        super(relacao, nivelPermissao, "profissional");
        this.perfiContato = perfiContato;
    }
    
    
    
    

}
