package com.appmed.app.domain;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "contato")
public class ContatoPessoal extends Contato {

    private static final long serialVersionUID = 3685343429859147984L;
    private String parentesco;
            
    @DBRef
    private Pessoal perfiContato;

    public ContatoPessoal(String parentesco, Pessoal perfiContato, String relacao, NivelPermissao nivelPermissao) {
        super(relacao, nivelPermissao, "pessoa");
        this.parentesco = parentesco;
        this.perfiContato = perfiContato;
    }
    
    
    
    
    
}
