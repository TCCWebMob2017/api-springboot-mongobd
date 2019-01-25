package com.appmed.app.domain.perfil;

import com.appmed.app.domain.AbstractEntityNetwork;
import com.appmed.app.domain.Usuario;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "doenca")
public class Doenca extends AbstractEntityNetwork implements Serializable {

    private static final long serialVersionUID = -5484001279238027764L;

    private String nome;
    private String CID;
    private String descricao;
    private List<String> nomesPopulares;
    
    
    public enum Sexo {
        apenas_homens, apenas_mulheres, ambos
    }

    public Doenca() {
        super();
    }

    public Doenca(String CID,String nome) {
        super();
        this.nome = nome;
        this.CID = CID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCID() {
        return CID;
    }

    public void setCID(String CID) {
        this.CID = CID;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<String> getNomesPopulares() {
        return nomesPopulares;
    }

    public void setNomesPopulares(List<String> nomesPopulares) {
        this.nomesPopulares = nomesPopulares;
    }
}
