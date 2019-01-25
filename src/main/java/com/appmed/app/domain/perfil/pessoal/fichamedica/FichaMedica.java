
package com.appmed.app.domain.perfil.pessoal.fichamedica;

import com.appmed.app.domain.Localidade;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.appmed.app.domain.Contato;
import java.time.LocalDateTime;
import java.util.List;

public class FichaMedica {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime nascimento;
    private String sexo;
    private Localidade residencia;
    private Localidade trabalho;
    private boolean praticaEsporte;
    private boolean doadorOrgao;
    private boolean doadorSangue;
    private String tipoSangue;
    private Double altura;
    private Double peso;
    
    private List<DoencaFicha> doencas;
    private List<AlergiaFicha> alergias;
    private List<MedicamentoFicha> medicamentos;
    private List<Cirurgia> cirutgias;
    private List<Contato> contatoEmergencia;
    private List<ProtocoloEmergencia> protocolosEmergencias;
    private List<Contato> profissionais;//medicos
    private List<Convenio> convenios;
    private List<DrogaFicha> drogas;

   
    public LocalDateTime getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDateTime nascimento) {
        this.nascimento = nascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Localidade getResidencia() {
        return residencia;
    }

    public void setResidencia(Localidade residencia) {
        this.residencia = residencia;
    }

    public Localidade getTrabalho() {
        return trabalho;
    }

    public void setTrabalho(Localidade trabalho) {
        this.trabalho = trabalho;
    }

    public boolean isPraticaEsporte() {
        return praticaEsporte;
    }

    public void setPraticaEsporte(boolean praticaEsporte) {
        this.praticaEsporte = praticaEsporte;
    }


    public boolean isDoadorOrgao() {
        return doadorOrgao;
    }

    public void setDoadorOrgao(boolean doadorOrgao) {
        this.doadorOrgao = doadorOrgao;
    }

    public boolean isDoadorSangue() {
        return doadorSangue;
    }

    public void setDoadorSangue(boolean doadorSangue) {
        this.doadorSangue = doadorSangue;
    }

    public String getTipoSangue() {
        return tipoSangue;
    }

    public void setTipoSangue(String tipoSangue) {
        this.tipoSangue = tipoSangue;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public List<DoencaFicha> getDoencas() {
        return doencas;
    }

    public void setDoencas(List<DoencaFicha> doencas) {
        this.doencas = doencas;
    }

    public List<AlergiaFicha> getAlergias() {
        return alergias;
    }

    public void setAlergias(List<AlergiaFicha> alergias) {
        this.alergias = alergias;
    }

    public List<MedicamentoFicha> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<MedicamentoFicha> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public List<Cirurgia> getCirutgias() {
        return cirutgias;
    }

    public void setCirutgias(List<Cirurgia> cirutgias) {
        this.cirutgias = cirutgias;
    }

    public List<Contato> getContatoEmergencia() {
        return contatoEmergencia;
    }

    public void setContatoEmergencia(List<Contato> contatoEmergencia) {
        this.contatoEmergencia = contatoEmergencia;
    }

    public List<ProtocoloEmergencia> getProtocolosEmergencias() {
        return protocolosEmergencias;
    }

    public void setProtocolosEmergencias(List<ProtocoloEmergencia> protocolosEmergencias) {
        this.protocolosEmergencias = protocolosEmergencias;
    }

    public List<Contato> getProfissionais() {
        return profissionais;
    }

    public void setProfissionais(List<Contato> profissionais) {
        this.profissionais = profissionais;
    }

    public List<Convenio> getConvenios() {
        return convenios;
    }

    public void setConvenios(List<Convenio> convenios) {
        this.convenios = convenios;
    }

    public List<DrogaFicha> getDrogas() {
        return drogas;
    }

    public void setDrogas(List<DrogaFicha> drogas) {
        this.drogas = drogas;
    }
    
}
