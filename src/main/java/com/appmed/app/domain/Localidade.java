package com.appmed.app.domain;

public class Localidade {

    private String nomeLocal;
    private String logradouro;
    private String CEP;
    private String bairro;
    private String cidade;
    private String estado;
    private String numero;

    public Localidade() {
    }

    public Localidade(String CEP) {
        this.CEP = CEP;
    }

    public Localidade(String logradouro, String bairro, String cidade, String estado, String numero, String CEP) {
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.numero = numero;
        this.CEP = CEP;
    }

    public Localidade(String nomeLocal, String logradouro, String bairro, String cidade, String estado, String numero, String CEP) {
        this.nomeLocal = nomeLocal;
        this.logradouro = logradouro;
        this.CEP = CEP;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.numero = numero;
    }

    public String getNomeLocal() {
        return nomeLocal;
    }

    public void setNomeLocal(String nomeLocal) {
        this.nomeLocal = nomeLocal;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

}
