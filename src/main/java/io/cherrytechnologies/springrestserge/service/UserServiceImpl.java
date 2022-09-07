package io.cherrytechnologies.springrestserge.service;

import io.cherrytechnologies.springrestserge.exceptions.UserExistsException;
import io.cherrytechnologies.springrestserge.exceptions.UserNotFoundException;
import io.cherrytechnologies.springrestserge.io.entity.UserEntity;
import io.cherrytechnologies.springrestserge.io.repository.UserRepository;
import io.cherrytechnologies.springrestserge.shared.dto.UserDto;
import io.cherrytechnologies.springrestserge.shared.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

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

        checkIfEmailExists(dto.getEmail());

        dto.setEncryptedPassword(encryptedPassword(dto.getPassword()));

        UserEntity entity = userRepository.save(UserMapper.dtoToEntity(dto));

        return UserMapper.entityToDto(entity);
    }

    @Override
    public UserDto findByEmail(String email) {
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException(userNotFoundExceptionMessage));

        return UserMapper.entityToDto(userEntity);
    }

    private String encryptedPassword(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    private void checkIfEmailExists(String email) throws UserExistsException {
        userRepository.findByEmail(email).ifPresent((entity) -> {
            throw new UserExistsException(userExistsExceptionMessage);
        });
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(userNotFoundExceptionMessage));

        return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), new ArrayList<>());
    }
}
