package com.appmed.app.domain;

import java.time.LocalDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import com.fasterxml.jackson.annotation.JsonFormat;

public class DoencaFicha extends InfoFichaMedica {

    @DBRef
    private Doenca doenca;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate desde;

    public DoencaFicha() {
    }

    public DoencaFicha(Doenca doenca) {
        super();
        this.doenca = doenca;
    }

    public DoencaFicha(Doenca doenca, NivelPermissao privacidade) {
        //    super(privacidade);
        super();
        this.doenca = doenca;
    }

    public DoencaFicha(Doenca doenca, LocalDate desde, NivelPermissao privacidade) {
        //    super(privacidade);
        super();
        this.doenca = doenca;
        this.desde = desde;
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

}
