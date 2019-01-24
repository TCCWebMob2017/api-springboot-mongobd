
package com.appmed.app.domain.perfil.pessoal.fichamedica;

import com.appmed.app.domain.perfil.Doenca;
import com.appmed.app.domain.perfil.Medicamento;
import com.appmed.app.domain.NivelPermissao;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class DoencaFicha extends InfoFichaMedica{
    @DBRef
    private Doenca doenca;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate desde;
    @DBRef
    private Medicamento medicamento;


    public DoencaFicha(Doenca doenca, LocalDate desde) {
        super();
        this.doenca = doenca;
    }

    public DoencaFicha(Doenca doenca, LocalDate desde, Medicamento medicamento, NivelPermissao privacidade) {
        super(privacidade);
        this.doenca = doenca;
        this.desde = desde;
        this.medicamento = medicamento;
    }

    
    public DoencaFicha(Doenca doenca) {
        this.doenca = doenca;
    }

    public Doenca getDoenca() {
        return doenca;
    }

    public void setDoenca(Doenca doenca) {
        this.doenca = doenca;
    }

    public LocalDate getDesde() {
        return desde;
    }

    public void setDesde(LocalDate desde) {
        this.desde = desde;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }


    
}
