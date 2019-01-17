
package com.appmed.app.domain.perfil.pessoal.fichamedica;

import com.appmed.app.domain.Privacidade;
import com.appmed.app.domain.perfil.CondicaoEspecial;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class CondicaoEspecialFicha extends InfoFichaMedica{
    @DBRef
    private CondicaoEspecial condicaoEpecial;

    private String descricao;
    
    public CondicaoEspecialFicha(String descricao) {
        super();
        this.descricao = descricao;
    }    

    public CondicaoEspecialFicha(String descricao, Privacidade privacidade) {
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
