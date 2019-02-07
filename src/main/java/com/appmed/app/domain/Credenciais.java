
package com.appmed.app.domain;

import java.io.Serializable;

public class Credenciais implements Serializable {

    private static final long serialVersionUID = 5015519306604256753L;
    private String email;
    private String password;

    public Credenciais() {
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
    
    
    
}
