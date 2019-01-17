
package com.appmed.app.domain.perfil.pessoal.fichamedica;

import com.appmed.app.domain.Privacidade;

public class ProtocoloEmergencia extends InfoFichaMedica{
    private String tipoEmergencia;
    private String descricao;


    public ProtocoloEmergencia(String tipoEmergencia, String descricao) {
        super();
        this.tipoEmergencia = tipoEmergencia;
        this.descricao = descricao;
    }

    public ProtocoloEmergencia(String tipoEmergencia, String descricao, Privacidade privacidade) {
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
