
package com.appmed.app.domain;

public class Privacidade {
    private boolean permissaoVisibilidade;
    private boolean permissaoGerenciamento = false;

    public Privacidade() {
    }

    public Privacidade(boolean permissaoVisibilidade, boolean permissaoGerenciamento) {
        this.permissaoVisibilidade = permissaoVisibilidade;
        this.permissaoGerenciamento = permissaoGerenciamento;
    }

    public boolean isPermissaoVisibilidade() {
        return permissaoVisibilidade;
    }

    public void setPermissaoVisibilidade(boolean permissaoVisibilidade) {
        this.permissaoVisibilidade = permissaoVisibilidade;
    }

    public boolean isPermissaoGerenciamento() {
        return permissaoGerenciamento;
    }

    public void setPermissaoGerenciamento(boolean permissaoGerenciamento) {
        this.permissaoGerenciamento = permissaoGerenciamento;
    }
    
    
}
