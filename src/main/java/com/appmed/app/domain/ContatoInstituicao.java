package com.appmed.app.domain;

import org.springframework.data.mongodb.core.mapping.DBRef;

public class ContatoInstituicao extends Contato {

    private static final long serialVersionUID = 200779978371663913L;

    @DBRef
    private Institucional perfiContato;
}
