
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
    private NivelPermissao nivelPermissao;
    private String tipoContato;
    @DBRef
    private UsuarioDTO contaPaciente;
    @DBRef
    private UsuarioDTO contaContato;

    public Contato() {
    super();
    }

    public Contato(String nome, String telefone) {
        super();
        this.nome = nome;
        this.telefone = telefone;
    }

    public Contato(String relacao, NivelPermissao nivelPermissao) {
        super();
        this.relacao = relacao;
        this.nivelPermissao = nivelPermissao;
    }

    public Contato(String relacao, NivelPermissao nivelPermissao, String tipoContato) {
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

    public NivelPermissao getNivelPermissao() {
        return nivelPermissao;
    }

    public void setNivelPermissao(NivelPermissao nivelPermissao) {
        this.nivelPermissao = nivelPermissao;
    }

    public String getTipoContato() {
        return tipoContato;
    }

    public void setTipoContato(String tipoContato) {
        this.tipoContato = tipoContato;
    }

    public UsuarioDTO getContaPaciente() {
        return contaPaciente;
    }

    public void setContaPaciente(UsuarioDTO contaPaciente) {
        this.contaPaciente = contaPaciente;
    }

    public UsuarioDTO getContaContato() {
        return contaContato;
    }

    public void setContaContato(UsuarioDTO contaContato) {
        this.contaContato = contaContato;
    } 
    
    
}
