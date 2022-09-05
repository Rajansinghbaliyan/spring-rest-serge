package io.cherrytechnologies.springrestserge.shared.dto;

import java.util.UUID;

public class UserDtoBuilder {
    protected UUID userId;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String password;
    protected String encryptedPassword;
    protected String emailVerificationToken;
    protected Boolean emailVerificationStatus;

    public UserDtoBuilder setUserId(UUID userId) {
        this.userId = userId;
        return this;
    }

    public UserDtoBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserDtoBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserDtoBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserDtoBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserDtoBuilder setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
        return this;
    }

    public UserDtoBuilder setEmailVerificationToken(String emailVerificationToken) {
        this.emailVerificationToken = emailVerificationToken;
        return this;
    }

    public UserDtoBuilder setEmailVerificationStatus(Boolean emailVerificationStatus) {
        this.emailVerificationStatus = emailVerificationStatus;
        return this;
    }

    public UserDto build(){
        return new UserDto(this);
    }
}
