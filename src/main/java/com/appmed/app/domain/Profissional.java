package com.appmed.app.domain;

import com.appmed.app.domain.perfil.profissional.Formacao;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;

public class Profissional extends Perfil implements Serializable {

    private static final long serialVersionUID = 4426284080596900227L;

    private String RG;
    private String CPF;
    private String CRM;

    private List<Formacao> formacoes;
    private List<Localidade> locaisTrabalho;
    private List<Institucional> instituicoesTrabalho;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate nascimento;
    private String sexo;

    private Profissao profissao;
    private Area areaAtuacao;

    private String descricao;//biografia Perfil

    private List<Pessoal> pacientes;

    public Profissional(Usuario createdBy, String nome) {
        super(createdBy, TipoPerfil.PROFISSIONAL, nome);
    }

    public Profissional(LocalDate nascimento, String sexo, Usuario createdBy, String nome) {
        super(createdBy, TipoPerfil.PROFISSIONAL, nome);
        this.nascimento = nascimento;
        this.sexo = sexo;
    }

    public Profissional(String RG, String CPF, LocalDate nascimento, String sexo,
            Profissao profissao, Area areaAtuacao, String descricao, Usuario createdBy, String nome) {
        super(createdBy, TipoPerfil.PROFISSIONAL, nome);
        this.RG = RG;
        this.CPF = CPF;
        this.nascimento = nascimento;
        this.sexo = sexo;
        this.profissao = profissao;
        this.areaAtuacao = areaAtuacao;
        this.descricao = descricao;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getCRM() {
        return CRM;
    }

    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    public List<Formacao> getFormacoes() {
        return formacoes;
    }

    public void setFormacoes(List<Formacao> formacoes) {
        this.formacoes = formacoes;
    }

    public List<Localidade> getLocaisTrabalho() {
        return locaisTrabalho;
    }

    public void setLocaisTrabalho(List<Localidade> locaisTrabalho) {
        this.locaisTrabalho = locaisTrabalho;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Profissao getProfissao() {
        return profissao;
    }

    public void setProfissao(Profissao profissao) {
        this.profissao = profissao;
    }

    public Area getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(Area areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Pessoal> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Pessoal> pacientes) {
        this.pacientes = pacientes;
    }

    public List<Institucional> getInstituicoesTrabalho() {
        return instituicoesTrabalho;
    }

    public void setInstituicoesTrabalho(List<Institucional> instituicoesTrabalho) {
        this.instituicoesTrabalho = instituicoesTrabalho;
    }

    public enum Profissao {
        MEDICO, FARMACEUTICO, ENFERMEIRO, TERAPEUTA, EDUCADOR_FISICO,OUTRO;
        /*
    Médico
    Farmacêutico (Farmaceuta)
    Odontólogo (Dentista)
    Optometrista
    Assistente Social
    Médico Veterinário (Veterinário)
    Enfermeiro
    Psicólogo
    Nutricionista
    Fisioterapeuta
    Terapeuta Ocupacional
    Biólogo
    Biomédico
    Audiologista
    Educador Físico
    Técnico em Enfermagem
    Técnico em Saneamento
    Técnico em Nutrição Dietética
    Técnico em Prótese Dentária (Protético)
    Ortoprotésico
    Paramédico (Socorrista)
    Técnico em Análises Clínicas
    Técnico em Optometria (Optometrista)
    Técnico em Ortóptica (Ortoptista)
    Técnico em Radiologia
    Técnico em Saúde Bucal
    Técnico em Reabilitação de Dependentes
    Técnico em Segurança do Trabalho
         */

    }

    public enum Area {
        SAUDE, ESPORTE, ESTETICA, FARMACIA, EDUCACAO, PESQUISA, OUTRA;
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
        Pessoal other = (Pessoal) obj;
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
