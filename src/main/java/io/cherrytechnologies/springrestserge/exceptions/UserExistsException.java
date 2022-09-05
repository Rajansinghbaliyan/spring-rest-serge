package io.cherrytechnologies.springrestserge.exceptions;

public class UserExistsException extends RuntimeException{
    private static final long serialVersionUID = -6093411001075057780L;

    public UserExistsException() {
        super();
    }

    public UserExistsException(String message) {
        super(message);
    }
}
