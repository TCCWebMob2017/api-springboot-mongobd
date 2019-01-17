
package com.appmed.app.domain.perfil.pessoal.fichamedica;

import com.appmed.app.domain.Privacidade;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;

public class Cirurgia extends InfoFichaMedica{
    private String nome;
    private String regiaoCorpo;
    private String descricao;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate data;

    public Cirurgia(String nome, String regiaoCorpo, String descricao, Privacidade privacidade) {
        super(privacidade);
        this.nome = nome;
        this.regiaoCorpo = regiaoCorpo;
        this.descricao = descricao;
    }


    public Cirurgia(String nome, String regiaoCorpo, String descricao) {
        super();
        this.nome = nome;
        this.regiaoCorpo = regiaoCorpo;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRegiaoCorpo() {
        return regiaoCorpo;
    }

    public void setRegiaoCorpo(String regiaoCorpo) {
        this.regiaoCorpo = regiaoCorpo;
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
