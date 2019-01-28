
package com.appmed.app.domain;

import com.appmed.app.domain.NivelPermissao;


public class InfoFichaMedica {
    private NivelPermissao privacidade;

    public InfoFichaMedica() {
    }
    
    public InfoFichaMedica(NivelPermissao privacidade) {
        this.privacidade = privacidade;
    }

    public NivelPermissao getPrivacidade() {
        return privacidade;
    }

    public void setPrivacidade(NivelPermissao privacidade) {
        this.privacidade = privacidade;
    }
        
        
}
