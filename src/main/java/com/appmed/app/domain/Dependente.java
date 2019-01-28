package com.appmed.app.domain;

import com.appmed.app.domain.Pessoal;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class Dependente extends InfoFichaMedica{

    private Parentesco parentesco;

    @DBRef
    private Pessoal perfil;

    public Dependente() {
    }
    
    public Dependente(Parentesco parentesco, Pessoal perfil) {
        super();
        this.parentesco = parentesco;
        this.perfil = perfil;
    }

    public Dependente(Pessoal perfil) {
        super();
        this.perfil = perfil;
    }
    
    public enum Parentesco {
        NENHUM(0), PAI(1), MAE(2), FILHO(3), FILHA(3),
        IRMAO(4), IRMA(4), AVO(5), NETO(6), NETA(6),
        SOGRO(7), SOGRA(7), GENRO(8), NORA(8),
        PADASTRO(9), MADASTRA(9), ENTIADO(10), ENTIADA(10),
        TIO(11), TIA(11), SOBRINHO(12), SOBRINHA(12),
        PRIMO(13), PRIMA(13),
        CUNHADO(14), CUNHADA(14);

        private final int valor;

        Parentesco(int valorOpcao) {
            valor = valorOpcao;
        }

        public int getIdParentesco() {
            return valor;
        }

        @Override
        public String toString() {
            return Integer.toString(valor);
        }
    }

    public Parentesco getParentesco() {
        return parentesco;
    }

    public void setParentesco(Parentesco parentesco) {
        this.parentesco = parentesco;
    }

    public Pessoal getPerfil() {
        return perfil;
    }

    public void setPerfil(Pessoal perfil) {
        this.perfil = perfil;
    }

}
