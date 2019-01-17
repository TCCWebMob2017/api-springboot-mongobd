
package com.appmed.app.domain.perfil.pessoal.fichamedica;

import com.appmed.app.domain.Privacidade;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;


public class Acidente extends InfoFichaMedica{
    private String descricao;
    private String implicacoes;
    private String gravidade;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate data;


    public Acidente(String descricao, String gravidade) {
        super();
        this.descricao = descricao;
        this.gravidade = gravidade;
    }

    public Acidente(String descricao, String gravidade, LocalDate data, Privacidade privacidade) {
        super(privacidade);
        this.descricao = descricao;
        this.gravidade = gravidade;
        this.data = data;
    }

    
    public Acidente(String descricao, String sequela, String gravidade, Privacidade privacidade) {
        super(privacidade);
        this.descricao = descricao;
        this.gravidade = gravidade;
    }

    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImplicacoes() {
        return implicacoes;
    }

    public void setImplicacoes(String implicacoes) {
        this.implicacoes = implicacoes;
    }


    public String getGravidade() {
        return gravidade;
    }

    public void setGravidade(String gravidade) {
        this.gravidade = gravidade;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
    
    

    
    
}
