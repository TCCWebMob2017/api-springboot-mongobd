
package com.appmed.app.domain;

import com.appmed.app.domain.NivelPermissao;
import com.appmed.app.domain.CondicaoEspecial;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class CondicaoEspecialFicha extends InfoFichaMedica{
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
        super(privacidade);
        this.condicaoEpecial = condicaoEpecial;
    }
    
   
    public CondicaoEspecialFicha(String descricao, NivelPermissao privacidade) {
        super(privacidade);
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    
}
