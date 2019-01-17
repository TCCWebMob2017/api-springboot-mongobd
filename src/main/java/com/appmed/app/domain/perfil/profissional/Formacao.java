package com.appmed.app.domain.perfil.profissional;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;

public class Formacao {

    private NivelCurso nivel;
    private String nomeCurso;
    private String cargaHoraria;
    private String titulo;
    private String localCurso;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataConclusao;

    public Formacao(NivelCurso nivel, String nomeCurso, String cargaHoraria,
            String titulo, String localCurso, LocalDate dataConclusao) {
        this.nivel = nivel;
        this.nomeCurso = nomeCurso;
        this.cargaHoraria = cargaHoraria;
        this.titulo = titulo;
        this.localCurso = localCurso;
        this.dataConclusao = dataConclusao;
    }

    public Formacao(NivelCurso nivel, String nomeCurso, String localCurso, LocalDate dataConclusao) {
        this.nivel = nivel;
        this.nomeCurso = nomeCurso;
        this.localCurso = localCurso;
        this.dataConclusao = dataConclusao;
    }

    public NivelCurso getNivel() {
        return nivel;
    }

    public void setNivel(NivelCurso nivel) {
        this.nivel = nivel;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLocalCurso() {
        return localCurso;
    }

    public void setLocalCurso(String localCurso) {
        this.localCurso = localCurso;
    }

    public LocalDate getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDate dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public enum NivelCurso {
        TECNICO, PROFISSIONALIZANTE, GRADUACAO, ESPECIALIZACAO,
        MESTRADO, DOUTORADO, POSDOUTORADO;
    }
}
