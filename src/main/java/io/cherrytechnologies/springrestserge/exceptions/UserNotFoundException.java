package io.cherrytechnologies.springrestserge.exceptions;

public class UserNotFoundException extends RuntimeException {
    private static final long serialVersionUID = -4602557042255537016L;

    public UserNotFoundException(String message) {
        super(message);
    }
}
