package com.appmed.app.exceptions;

public class NotFound extends Exception {

    private static final long serialVersionUID = -8613886387063802199L;

    public NotFound() {
    }

    public NotFound(String message) {
        super(message);
    }
}
