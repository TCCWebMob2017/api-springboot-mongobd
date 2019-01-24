package com.appmed.app.exceptions;

public class NotFound extends Exception {

    private static final long serialVersionUID = -1072101751492756852L;

    public NotFound() {
    }

    public NotFound(String message) {
        super(message);
    }
}
