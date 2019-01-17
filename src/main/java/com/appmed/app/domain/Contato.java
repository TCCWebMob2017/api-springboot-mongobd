
package com.appmed.app.domain;

import com.appmed.app.domain.perfil.pessoal.Dependente;
import com.appmed.app.domain.perfil.pessoal.Dependente.Parentesco;
import java.io.Serializable;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "contato")
public class Contato extends AbstractEntityNetwork implements Serializable {

    private static final long serialVersionUID = 4907054172477100446L;

    private String nome;
    private String phone;
    private String email;
    private String relacao;//tipo de relacionamento com contato amigo, parente, medico
    private Parentesco familiar;
    private Privacidade privacidade;
    @DBRef
    private Usuario contaContato;
   
    public Contato(String nome, String phone, String email, String relacao, 
            Privacidade privacidade, Usuario createdBy) {
        super(createdBy);
        this.nome = nome;
        this.phone = phone;
        this.email = email;
        this.relacao = relacao;
        this.privacidade = privacidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public Privacidade getPrivacidade() {
        return privacidade;
    }

    public void setPrivacidade(Privacidade privacidade) {
        this.privacidade = privacidade;
    }
    
    
}
