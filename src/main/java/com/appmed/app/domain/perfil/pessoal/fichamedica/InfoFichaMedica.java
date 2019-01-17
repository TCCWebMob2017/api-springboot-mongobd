
package com.appmed.app.domain.perfil.pessoal.fichamedica;

import com.appmed.app.domain.Privacidade;


public class InfoFichaMedica {
    private Privacidade privacidade;

    public InfoFichaMedica() {
        this.privacidade = new Privacidade (true,false);
    }
    
    public InfoFichaMedica(Privacidade privacidade) {
        this.privacidade = privacidade;
    }

    public Privacidade getPrivacidade() {
        return privacidade;
    }

    public void setPrivacidade(Privacidade privacidade) {
        this.privacidade = privacidade;
    }
        
        
}
