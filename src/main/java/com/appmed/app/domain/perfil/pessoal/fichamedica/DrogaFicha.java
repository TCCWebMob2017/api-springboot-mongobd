
package com.appmed.app.domain.perfil.pessoal.fichamedica;

import com.appmed.app.domain.Privacidade;
import com.appmed.app.domain.perfil.Droga;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class DrogaFicha extends InfoFichaMedica{
    @DBRef
    private Droga droga;
    private String quantidade;
    private String frequecia;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate desde;



    public DrogaFicha(String quantidade, String frequecia) {
        super();
        this.quantidade = quantidade;
        this.frequecia = frequecia;
    }
    
    public DrogaFicha(String quantidade, String frequecia, Privacidade privacidade) {
        super(privacidade);
        this.quantidade = quantidade;
        this.frequecia = frequecia;
    }

    public DrogaFicha(String quantidade, String frequecia, LocalDate desde, Privacidade privacidade) {
        super(privacidade);
        this.quantidade = quantidade;
        this.frequecia = frequecia;
        this.desde = desde;
    }
    

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getFrequecia() {
        return frequecia;
    }

    public void setFrequecia(String frequecia) {
        this.frequecia = frequecia;
    }

    public LocalDate getDesde() {
        return desde;
    }

    public void setDesde(LocalDate desde) {
        this.desde = desde;
    }

    
}
