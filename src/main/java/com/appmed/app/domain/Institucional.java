package com.appmed.app.domain;

import com.appmed.app.domain.perfil.instituicional.Funcionario;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "instituicao")
public class Institucional extends Perfil implements Serializable {

    private static final long serialVersionUID = -1092737089860131982L;

    private String CNPJ;
    private String inscricaoEstadual;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataAbertura;
    private String site;
    private String email;
    private Localidade endereco;
    private String telefone;
    private String celular;
    private Area areaAtividade;
    private Tipo tipo;

    private String descricao;

    private List<Funcionario> funcionarios;

    public Institucional() {
        this.setTipoPerfil(TipoPerfil.ORGANIZACAO);
    }

    public Institucional(String CNPJ, String inscricaoEstadual, LocalDate dataAbertura, String email, Localidade endereco, String telefone, Area areaAtividade, Usuario createdBy, String nome) {
        super(TipoPerfil.ORGANIZACAO, nome);
        this.CNPJ = CNPJ;
        this.inscricaoEstadual = inscricaoEstadual;
        this.dataAbertura = dataAbertura;
        this.email = email;
        this.endereco = endereco;
        this.telefone = telefone;
        this.areaAtividade = areaAtividade;
    }

    public Institucional(String CNPJ, String inscricaoEstadual, LocalDate dataAbertura, String site, String email, Localidade endereco, String telefone, String celular, Area areaAtividade, String descricao, Usuario createdBy, String nome) {
        super(TipoPerfil.ORGANIZACAO, nome);
        this.CNPJ = CNPJ;
        this.inscricaoEstadual = inscricaoEstadual;
        this.dataAbertura = dataAbertura;
        this.site = site;
        this.email = email;
        this.endereco = endereco;
        this.telefone = telefone;
        this.celular = celular;
        this.areaAtividade = areaAtividade;
        this.descricao = descricao;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Localidade getEndereco() {
        return endereco;
    }

    public void setEndereco(Localidade endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Area getAreaAtividade() {
        return areaAtividade;
    }

    public void setAreaAtividade(Area areaAtividade) {
        this.areaAtividade = areaAtividade;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public enum Tipo {
        HOSPITAL, ACADEMIA, CLINICA, FARMACIA, ESCOLA, CLUBE, OUTRA;
    }

    public enum Area {
        MEDICA, SAUDE, ACADEMICA, EDUCACAO, OUTRA;
    }


    public void addFuncionario(Funcionario element) {
        funcionarios.add(element);
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Institucional other = (Institucional) obj;
        if (getId() == null) {
            if (other.getId() != null) {
                return false;
            }
        } else if (!getId().equals(other.getId())) {
            return false;
        }
        return true;
    }

}
