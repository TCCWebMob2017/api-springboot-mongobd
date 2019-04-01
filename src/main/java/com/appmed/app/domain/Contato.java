
package com.appmed.app.domain;

import com.appmed.app.domain.Dependente.Parentesco;
import java.io.Serializable;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "contato")
public class Contato extends AbstractEntityNetwork implements Serializable {

    private static final long serialVersionUID = 4907054172477100446L;

    private String nome;
    private String telefone;
    private String email;
    private String relacao;//tipo de relacionamento com contato amigo, parente, medico
    private int nivelPermissao;
    private String tipoContato;
    @DBRef
    private UsuarioDTO paciente;
    @DBRef
    private UsuarioDTO contato;

    public Contato() {
    super();
    }

    public Contato(String nome, String telefone) {
        super();
        this.nome = nome;
        this.telefone = telefone;
    }

    public Contato(String relacao, int nivelPermissao) {
        super();
        this.relacao = relacao;
        this.nivelPermissao = nivelPermissao;
    }

    public Contato(String relacao, int nivelPermissao, String tipoContato) {
        super();
        this.relacao = relacao;
        this.nivelPermissao = nivelPermissao;
        this.tipoContato = tipoContato;
    }
    

    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRelacao() {
        return relacao;
    }

    public void setRelacao(String relacao) {
        this.relacao = relacao;
    }

    public int getNivelPermissao() {
        return nivelPermissao;
    }

    public void setNivelPermissao(int nivelPermissao) {
        this.nivelPermissao = nivelPermissao;
    }

    public String getTipoContato() {
        return tipoContato;
    }

    public void setTipoContato(String tipoContato) {
        this.tipoContato = tipoContato;
    }    

    public UsuarioDTO getPaciente() {
        return paciente;
    }

    public void setPaciente(UsuarioDTO paciente) {
        this.paciente = paciente;
    }

    public UsuarioDTO getContato() {
        return contato;
    }

    public void setContato(UsuarioDTO contato) {
        this.contato = contato;
    }

}
