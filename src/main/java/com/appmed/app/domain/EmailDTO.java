
package com.appmed.app.domain;

import java.io.Serializable;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Email;



public class EmailDTO implements Serializable {

    private static final long serialVersionUID = 2612770578964724302L;

	@NotEmpty(message="Preenchimento obrigatório")
	@Email(message="Email inválido")
	private String email;

	public EmailDTO() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}