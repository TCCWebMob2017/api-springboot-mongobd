package com.appmed.app.domain;

import com.appmed.app.domain.AbstractEntityNetwork;
import com.appmed.app.domain.Usuario;
import java.io.Serializable;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "alergia")
public class Alergia extends AbstractEntityNetwork implements Serializable {

    private static final long serialVersionUID = -7137539624241707176L;

    private String nome;
    private String categoria;
    private String descricao;
    private String agenteCausador;
    private String reaçõesAdversas;

    public Alergia() {
        super();
    }

    public Alergia(String nome) {
        super();
        this.nome = nome;
    }

 
    public Alergia(String nome, String categoria) {
        super();
        this.nome = nome;
        this.categoria = categoria;
    }

       /*A = Alimentos
    P = Princípio Ativo
    M = Medicamento
    C = Classe de Medicamentos
O = Outros*/
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAgenteCausador() {
        return agenteCausador;
    }

    public void setAgenteCausador(String agenteCausador) {
        this.agenteCausador = agenteCausador;
    }

    public String getReaçõesAdversas() {
        return reaçõesAdversas;
    }

    public void setReaçõesAdversas(String reaçõesAdversas) {
        this.reaçõesAdversas = reaçõesAdversas;
    }

}
