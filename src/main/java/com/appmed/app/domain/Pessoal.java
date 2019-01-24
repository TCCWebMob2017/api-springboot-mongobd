package com.appmed.app.domain;

import com.appmed.app.domain.perfil.pessoal.fichamedica.AlergiaFicha;
import com.appmed.app.domain.perfil.pessoal.fichamedica.Cirurgia;
import com.appmed.app.domain.perfil.pessoal.Dependente;
import com.appmed.app.domain.perfil.pessoal.fichamedica.DoencaFicha;
import com.appmed.app.domain.perfil.pessoal.fichamedica.DrogaFicha;
import com.appmed.app.domain.perfil.pessoal.fichamedica.MedicamentoFicha;
import com.appmed.app.domain.perfil.pessoal.fichamedica.ProtocoloEmergencia;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.appmed.app.domain.perfil.pessoal.fichamedica.Convenio;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pessoal extends Perfil implements Serializable {

    private static final long serialVersionUID = 3104508455191920797L;

    private String RG;
    private String CPF;
    private Localidade residencia;
    private Localidade trabalho;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate nascimento;
    private String sexo;
    private boolean praticaEsporte;
    private boolean doadorOrgao;
    private boolean doadorSangue;
    private String tipoSangue;
    private Double altura;
    private Double peso;

    private List<Dependente> dependentes;
    private List<DoencaFicha> doencas;
    private List<AlergiaFicha> alergias;
    private List<MedicamentoFicha> medicamentos;
    private List<Cirurgia> cirurgias;
    private List<Contato> contatoEmergencia;
    private List<ProtocoloEmergencia> protocolosEmergencias;
    private List<Contato> profissionais;//medicos
    private List<Convenio> convenios;
    private List<DrogaFicha> drogas;

    public Pessoal() {
        super();
    }

    public Pessoal(Usuario usuario, TipoPerfil tipoPerfil, Localidade residencia,
            Localidade trabalho,
            LocalDate nascimento,
            String sexo,
            boolean praticaEsporte, boolean doadorOrgao, boolean doadorSangue,
            String tipoSangue, Double altura, Double peso) {
        super(usuario, tipoPerfil);
        this.residencia = residencia;
        //this.residencia.setNomeLocal("residencia");
        this.trabalho = trabalho;
        //this.trabalho.setNomeLocal("trabalho");
        this.nascimento = nascimento;
        this.sexo = sexo;
        this.praticaEsporte = praticaEsporte;
        this.doadorOrgao = doadorOrgao;
        this.doadorSangue = doadorSangue;
        this.tipoSangue = tipoSangue;
        this.altura = altura;
        this.peso = peso;
        if (this.getTipoPerfil().equals(TipoPerfil.PESSOAL)) {
            this.CPF = usuario.getCpf();
            this.RG = usuario.getRg();
            this.setNome(this.getCreatedByUser().getNome());

        }
    }

    public Pessoal(Localidade residencia, LocalDate nascimento, String sexo, boolean praticaEsporte, boolean doadorOrgao, boolean doadorSangue, String tipoSangue, Double altura, Double peso, Usuario createdBy) {
        super(createdBy, TipoPerfil.PESSOAL, createdBy.getNome());
        this.residencia = residencia;
        this.nascimento = nascimento;
        this.sexo = sexo;
        this.praticaEsporte = praticaEsporte;
        this.doadorOrgao = doadorOrgao;
        this.doadorSangue = doadorSangue;
        this.tipoSangue = tipoSangue;
        this.altura = altura;
        this.peso = peso;
        this.RG=createdBy.getRg();
        this.CPF=createdBy.getCpf();
    }

    public Pessoal(Localidade residencia, LocalDate nascimento, String sexo,
            String tipoSangue, Double altura, Double peso, Usuario createdBy) {
        super(createdBy, TipoPerfil.PESSOAL, createdBy.getNome());
        this.residencia = residencia;
        this.nascimento = nascimento;
        this.sexo = sexo;
        this.tipoSangue = tipoSangue;
        this.altura = altura;
        this.peso = peso;
        this.residencia = residencia;
        this.nascimento = nascimento;
        this.sexo = sexo;
        this.tipoSangue = tipoSangue;
        this.RG=createdBy.getRg();
        this.CPF=createdBy.getCpf();
    }

    
    public Pessoal(Usuario usuario, TipoPerfil tipoPerfil, String nome, String RG,
            String CPF, Localidade residencia, Localidade trabalho,
            LocalDate nascimento,
            String sexo, boolean praticaEsporte, boolean doadorOrgao,
            boolean doadorSangue,
            String tipoSangue, Double altura, Double peso) {
        super(usuario, tipoPerfil, nome);
        this.RG = RG;
        this.CPF = CPF;
        this.residencia = residencia;
        this.trabalho = trabalho;
        this.nascimento = nascimento;
        this.sexo = sexo;
        this.praticaEsporte = praticaEsporte;
        this.doadorOrgao = doadorOrgao;
        this.doadorSangue = doadorSangue;
        this.tipoSangue = tipoSangue;
        this.altura = altura;
        this.peso = peso;
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

    public List<Dependente> getDependentes() {
        return dependentes;
    }

    public void setDependentes(List<Dependente> dependentes) {
        this.dependentes = dependentes;
    }

    public boolean add(Dependente e) {
        if (this.dependentes == null) {
            this.dependentes = new ArrayList<>();
        }
        return this.dependentes.add(e);
    }

    public boolean remove(Dependente e) {
        return dependentes.remove(e);
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

    public List<Cirurgia> getCirurgias() {
        return cirurgias;
    }

    public void setCirurgias(List<Cirurgia> cirurgias) {
        this.cirurgias = cirurgias;
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
