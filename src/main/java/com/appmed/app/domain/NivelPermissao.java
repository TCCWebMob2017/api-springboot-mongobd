
package com.appmed.app.domain;

public class NivelPermissao {
    private Tipo nivel;

    public NivelPermissao() {
    }
    public enum Tipo {
        RESTRITO, VISUALIZAVEL, EDITAVEL;
    }
}
