
package com.appmed.app.domain.perfil.pessoal.fichamedica;

import com.appmed.app.domain.NivelPermissao;


public class Convenio extends InfoFichaMedica{
    private String codigoUsuarioConvenio;
    private String nomeConvenio;

    public Convenio() {
    }


    public Convenio(String codigousuarioConvenio, String nomeConvenio) {
        super();
        this.codigoUsuarioConvenio = codigousuarioConvenio;
        this.nomeConvenio = nomeConvenio;
    }

    public Convenio(String codigoUsuarioConvenio, String nomeConvenio, NivelPermissao privacidade) {
        super(privacidade);
        this.codigoUsuarioConvenio = codigoUsuarioConvenio;
        this.nomeConvenio = nomeConvenio;
    }

    
    
    public String getCodigousuarioConvenio() {
        return codigoUsuarioConvenio;
    }

    public void setCodigousuarioConvenio(String codigousuarioConvenio) {
        this.codigoUsuarioConvenio = codigousuarioConvenio;
    }

    public String getNomeConvenio() {
        return nomeConvenio;
    }

    public void setNomeConvenio(String nomeConvenio) {
        this.nomeConvenio = nomeConvenio;
    }

    
}
