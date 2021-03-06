
package com.appmed.app.domain;

import com.appmed.app.domain.NivelPermissao;

public class ProtocoloEmergencia extends InfoFichaMedica{
    private String tipoEmergencia;
    private String descricao;

    public ProtocoloEmergencia() {
    }


    public ProtocoloEmergencia(String tipoEmergencia, String descricao) {
        super();
        this.tipoEmergencia = tipoEmergencia;
        this.descricao = descricao;
    }

    public ProtocoloEmergencia(String tipoEmergencia, String descricao, NivelPermissao privacidade) {
        super(privacidade);
        this.tipoEmergencia = tipoEmergencia;
        this.descricao = descricao;
    }

    public String getTipoEmergencia() {
        return tipoEmergencia;
    }

    public void setTipoEmergencia(String tipoEmergencia) {
        this.tipoEmergencia = tipoEmergencia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
