package io.cherrytechnologies.springrestserge.service;

import io.cherrytechnologies.springrestserge.io.repository.UserRepository;
import io.cherrytechnologies.springrestserge.shared.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto getUserById(UUID id) {
        return null;
    }

    @Override
    public UserDto saveUser(UserDto dto) {
        return null;
    }
}
