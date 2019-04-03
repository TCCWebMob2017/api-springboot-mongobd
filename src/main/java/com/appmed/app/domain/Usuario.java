package com.appmed.app.domain;

import com.appmed.app.domain.enums.TipoUsuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usuario")
public class Usuario extends AbstractDocument implements Serializable {

    private static final long serialVersionUID = -8703831001278409915L;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String nome;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Indexed(unique = true)
    @Email
    private String email;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String password;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String tefefone;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Indexed(unique = true)
    @CPF
    private String cpf;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String rg;
    private boolean enabled;

    //private String imageUrl;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "TIPOUSUARIOS")
    private Set<Integer> tipos = new HashSet<>();

    @DBRef
    private Pessoal perfilPessoal;

    @DBRef
    private Profissional perfilProfissional;

    @DBRef
    private List<Institucional> perfisInstituicoes;

    //@DBRef
    //private Set<Role> roles;
    public Usuario() {
        super();
        addTipo(TipoUsuario.PACIENTE);
    }

    public Usuario(String nome, String email, String password, String tefefone, String cpf, String rg) {
        super();
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.tefefone = tefefone;
        this.cpf = cpf;
        this.rg = rg;
        addTipo(TipoUsuario.PACIENTE);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTefefone() {
        return tefefone;
    }

    public void setTefefone(String tefefone) {
        this.tefefone = tefefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Pessoal getPerfilPessoal() {
        return perfilPessoal;
    }

    public void setPerfilPessoal(Pessoal perfilPessoal) {
        this.perfilPessoal = perfilPessoal;
    }

    public Profissional getPerfilProfissional() {
        return perfilProfissional;
    }

    public void setPerfilProfissional(Profissional perfilProfissional) {
        this.perfilProfissional = perfilProfissional;
    }

    public List<Institucional> getPerfisInstituicoes() {
        return perfisInstituicoes;
    }

    public void setPerfisInstituicoes(List<Institucional> perfisInstituicoes) {
        this.perfisInstituicoes = perfisInstituicoes;
    }

    public Set<TipoUsuario> getTipos() {
        return tipos.stream().map(x -> TipoUsuario.toEnum(x)).collect(Collectors.toSet());
    }

    public void addTipo(TipoUsuario tipo) {
        tipos.add(tipo.getCod());
    }

    public boolean add(Institucional e) {
        if (this.perfisInstituicoes == null) {
            this.perfisInstituicoes = new ArrayList<Institucional>();
        };
        return perfisInstituicoes.add(e);
    }

    public boolean remove(Object o) {
        return perfisInstituicoes.remove(o);
    }

    /*public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }*/

    @Override
    public String toString() {
        return "Usuario{" + "nome=" + nome + ", email=" + email + ", tefefone=" + tefefone + ", cpf=" + cpf + ", rg=" + rg + ", enabled=" + enabled + '}';
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
        Usuario other = (Usuario) obj;
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
