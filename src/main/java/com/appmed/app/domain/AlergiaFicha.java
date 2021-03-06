
package com.appmed.app.domain;

import com.appmed.app.domain.NivelPermissao;
import com.appmed.app.domain.Alergia;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class AlergiaFicha extends InfoFichaMedica{
    @DBRef
    private Alergia alergia;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate desde;

    public AlergiaFicha() {
    }
   
 
    public AlergiaFicha(Alergia alergia, NivelPermissao privacidade) {
        super(privacidade);
        this.alergia = alergia;
    }

    public AlergiaFicha(Alergia alergia, LocalDate desde) {
        super();
        this.alergia = alergia;
        this.desde = desde;
    }

    public AlergiaFicha(Alergia alergia, LocalDate desde, NivelPermissao privacidade) {
        super(privacidade);
        this.alergia = alergia;
        this.desde = desde;
    }

    public Alergia getAlergia() {
        return alergia;
    }

    public void setAlergia(Alergia alergia) {
        this.alergia = alergia;
    }

    public LocalDate getDesde() {
        return desde;
    }

    public void setDesde(LocalDate desde) {
        this.desde = desde;
    }
    
    

   
    
}
