
package com.appmed.app.domain;

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

    public DrogaFicha() {
    }

    public DrogaFicha(String quantidade, String frequecia) {
        super();
        this.quantidade = quantidade;
        this.frequecia = frequecia;
    }

    public DrogaFicha(Droga droga, NivelPermissao privacidade) {
        super(privacidade);
        this.droga = droga;
    }

    
    public DrogaFicha(String quantidade, String frequecia, NivelPermissao privacidade) {
        super(privacidade);
        this.quantidade = quantidade;
        this.frequecia = frequecia;
    }

    public DrogaFicha(String quantidade, String frequecia, LocalDate desde, NivelPermissao privacidade) {
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

    public Droga getDroga() {
        return droga;
    }

    public void setDroga(Droga droga) {
        this.droga = droga;
    }

    
}
