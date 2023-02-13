package com.fse0.microservice.gateway.exceptions;

import javax.naming.AuthenticationException;

public class JwtTokenMissingException extends AuthenticationException {

    private static final long serialVersionUID = 1L;
    public JwtTokenMissingException(String msg) {
        super(msg);
    }

}
