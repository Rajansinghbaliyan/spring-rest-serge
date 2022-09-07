package io.cherrytechnologies.springrestserge.service;

import io.cherrytechnologies.springrestserge.shared.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface UserService extends UserDetailsService {
    public UserDto getUserById(UUID id);
    public UserDto saveUser(UserDto dto);

    public UserDto findByEmail(String email);
}
