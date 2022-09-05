package io.cherrytechnologies.springrestserge.service;

import io.cherrytechnologies.springrestserge.shared.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface UserService {
    public UserDto getUserById(UUID id);
    public UserDto saveUser(UserDto dto);
}
