
package com.appmed.app.domain;

import com.appmed.app.domain.Medicamento;
import com.appmed.app.domain.NivelPermissao;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class MedicamentoFicha extends InfoFichaMedica{
    @DBRef 
    private Medicamento medicamento;
    private String dosagem;
    private String periodicidade;
    private String viaAdministracao;

    public MedicamentoFicha() {
    }
    
    public MedicamentoFicha(Medicamento medicamento, String dosagem, String frequencia, String viaAdministracao, NivelPermissao privacidade) {
        super(privacidade);
        this.medicamento = medicamento;
        this.dosagem = dosagem;
        this.periodicidade = frequencia;
        this.viaAdministracao = viaAdministracao;
    }

    public MedicamentoFicha(Medicamento medicamento, NivelPermissao privacidade) {
        super(privacidade);
        this.medicamento = medicamento;
    }

    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    public String getFrequencia() {
        return periodicidade;
    }

    public void setFrequencia(String frequencia) {
        this.periodicidade = frequencia;
    }

    public String getViaAdministracao() {
        return viaAdministracao;
    }

    public void setViaAdministracao(String viaAdministracao) {
        this.viaAdministracao = viaAdministracao;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }
    
}
