package com.appmed.app.domain;

import org.springframework.data.mongodb.core.mapping.DBRef;

public class CondicaoEspecialFicha extends InfoFichaMedica {

    @DBRef
    private CondicaoEspecial condicaoEpecial;

    private String descricao;

    public CondicaoEspecialFicha() {
    }

    public CondicaoEspecialFicha(String descricao) {
        super();
        this.descricao = descricao;
    }

    public CondicaoEspecialFicha(CondicaoEspecial condicaoEpecial) {
        super();
        this.condicaoEpecial = condicaoEpecial;
    }

    public CondicaoEspecialFicha(CondicaoEspecial condicaoEpecial, NivelPermissao privacidade) {
        //    super(privacidade);
        super();
        this.condicaoEpecial = condicaoEpecial;
    }

    public CondicaoEspecialFicha(String descricao, NivelPermissao privacidade) {
        //    super(privacidade);
        super();
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public CondicaoEspecial getCondicaoEpecial() {
        return condicaoEpecial;
    }

    public void setCondicaoEpecial(CondicaoEspecial condicaoEpecial) {
        this.condicaoEpecial = condicaoEpecial;
    }

}
