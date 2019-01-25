
package com.appmed.app.domain.perfil.pessoal.fichamedica;

import com.appmed.app.domain.NivelPermissao;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;

public class Cirurgia extends InfoFichaMedica{

    private String descricao;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate data;

    public Cirurgia() {
    }


    public Cirurgia( String descricao, NivelPermissao privacidade) {
        super(privacidade);
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    
}
