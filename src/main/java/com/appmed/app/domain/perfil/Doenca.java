
package com.appmed.app.domain.perfil;

import com.appmed.app.domain.AbstractEntityNetwork;
import com.appmed.app.domain.Usuario;
import java.io.Serializable;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "doenca")
public class Doenca  extends AbstractEntityNetwork implements Serializable {

    private static final long serialVersionUID = -5484001279238027764L;

    private String nome;
    private String CID;


    public Doenca() {
        super();
    }

    public Doenca(String nome, String CID, Usuario createdByUser) {
        super(createdByUser);
        this.nome = nome;
        this.CID = CID;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCID() {
        return CID;
    }

    public void setCID(String CID) {
        this.CID = CID;
    }

    
}
