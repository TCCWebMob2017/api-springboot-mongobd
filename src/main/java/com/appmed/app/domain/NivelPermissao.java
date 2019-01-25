package com.appmed.app.domain;

public class NivelPermissao {

    private Tipo nivel;

    public NivelPermissao() {
    }

    public NivelPermissao(int valor) {
        switch (valor) {
            case 1:
                this.nivel = Tipo.VISUALIZAVEL;
                break;
            case 2:
                this.nivel = Tipo.EDITAVEL;
                break;
            case 3:
                this.nivel = Tipo.RESTRITO;
                break;
            default: {
                this.nivel = Tipo.VISUALIZAVEL;
            }
            break;
        }
        ;
    }

    public enum Tipo {
        RESTRITO, VISUALIZAVEL, EDITAVEL;
    }
    
    
}
