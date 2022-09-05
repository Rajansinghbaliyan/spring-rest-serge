package io.cherrytechnologies.springrestserge.service;

import io.cherrytechnologies.springrestserge.exceptions.UserExistsException;
import io.cherrytechnologies.springrestserge.exceptions.UserNotFoundException;
import io.cherrytechnologies.springrestserge.io.entity.UserEntity;
import io.cherrytechnologies.springrestserge.io.repository.UserRepository;
import io.cherrytechnologies.springrestserge.shared.dto.UserDto;
import io.cherrytechnologies.springrestserge.shared.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.UUID;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Value("${user.not.found}")
    private String userNotFoundExceptionMessage;

    @Value("${user.exists}")
    private String userExistsExceptionMessage;

    @Override
    public UserDto getUserById(UUID id) {
        UserEntity entity = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(userNotFoundExceptionMessage));
        return UserMapper.entityToDto(entity);
    }

    @Override
    public UserDto saveUser(UserDto dto) {

        dto.setUserId(null);
        userRepository.findByEmail(dto.getEmail()).ifPresent((entity) -> {
            throw new UserExistsException(userExistsExceptionMessage);
        });

        UserEntity entity = userRepository.save(UserMapper.dtoToEntity(dto));

        return UserMapper.entityToDto(entity);
    }
}
