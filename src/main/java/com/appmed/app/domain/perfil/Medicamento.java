
package com.appmed.app.domain.perfil;

import com.appmed.app.domain.AbstractEntityNetwork;
import com.appmed.app.domain.Usuario;
import java.io.Serializable;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "medicamento")
public class Medicamento extends AbstractEntityNetwork implements Serializable {

    private static final long serialVersionUID = 621849506322915908L;

    private String nome;
    
    private boolean generico;
    private String principioAtivo;
    private String concentracao;
    private String formaFarmaceutica;//COMPRIMIDO REVESTIDO;
    private String nomeComercial;
    private String laboratorio;
    private String composicao;
    private String indicacao;
    private String dosagemAdultos;
    private String dosagemPediatrica;
    private String reacoesAdversas;
    private String contraindicacoes;
    private String gravidez;
    private String lactacao;
    private String contraindicacao;
    private String efeitosColaterais;
    

    
    public Medicamento(String nome, Usuario createdByUser) {
        super(createdByUser);
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean getGenerico() {
        return generico;
    }

    public void setGenerico(boolean generico) {
        this.generico = generico;
    }

    public String getPrincipioAtivo() {
        return principioAtivo;
    }

    public void setPrincipioAtivo(String principioAtivo) {
        this.principioAtivo = principioAtivo;
    }

    public String getConcentracao() {
        return concentracao;
    }

    public void setConcentracao(String concentracao) {
        this.concentracao = concentracao;
    }

    public String getFormaFarmaceutica() {
        return formaFarmaceutica;
    }

    public void setFormaFarmaceutica(String formaFarmaceutica) {
        this.formaFarmaceutica = formaFarmaceutica;
    }

    public String getNomeComercial() {
        return nomeComercial;
    }

    public void setNomeComercial(String nomeComercial) {
        this.nomeComercial = nomeComercial;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getComposicao() {
        return composicao;
    }

    public void setComposicao(String composicao) {
        this.composicao = composicao;
    }

    public String getIndicacao() {
        return indicacao;
    }

    public void setIndicacao(String indicacao) {
        this.indicacao = indicacao;
    }

    public String getDosagemAdultos() {
        return dosagemAdultos;
    }

    public void setDosagemAdultos(String dosagemAdultos) {
        this.dosagemAdultos = dosagemAdultos;
    }

    public String getDosagemPediatrica() {
        return dosagemPediatrica;
    }

    public void setDosagemPediatrica(String dosagemPediatrica) {
        this.dosagemPediatrica = dosagemPediatrica;
    }

    public String getReacoesAdversas() {
        return reacoesAdversas;
    }

    public void setReacoesAdversas(String reacoesAdversas) {
        this.reacoesAdversas = reacoesAdversas;
    }

    public String getContraindicacoes() {
        return contraindicacoes;
    }

    public void setContraindicacoes(String contraindicacoes) {
        this.contraindicacoes = contraindicacoes;
    }

    public String getGravidez() {
        return gravidez;
    }

    public void setGravidez(String gravidez) {
        this.gravidez = gravidez;
    }

    public String getLactacao() {
        return lactacao;
    }

    public void setLactacao(String lactacao) {
        this.lactacao = lactacao;
    }
    
    
    
}
