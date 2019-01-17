package com.appmed.app.domain;

import org.springframework.data.mongodb.core.mapping.DBRef;

public class AbstractEntityNetwork extends AbstractDocument{
    @DBRef
    private Usuario createdByUser;

    public AbstractEntityNetwork() {
        super();
    }

    public AbstractEntityNetwork(Usuario createdByUser) {
        super();
        this.createdByUser = createdByUser;
    }

    public Usuario getCreatedByUser() {
        return createdByUser;
    }

    public void setCreatedByUser(Usuario createdByUser) {
        this.createdByUser = createdByUser;
    }
    
    
}
