
package com.appmed.app.domain;

import com.appmed.app.domain.NivelPermissao;


public class InfoFichaMedica {
    private NivelPermissao privacidade;
    private String observacao;

    public InfoFichaMedica() {
    }
    
    public InfoFichaMedica(NivelPermissao privacidade) {
        this.privacidade = privacidade;
    }

    public InfoFichaMedica(NivelPermissao privacidade, String observacao) {
        this.privacidade = privacidade;
        this.observacao = observacao;
    }

    
    public NivelPermissao getPrivacidade() {
        return privacidade;
    }

    public void setPrivacidade(NivelPermissao privacidade) {
        this.privacidade = privacidade;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
        
        
}
