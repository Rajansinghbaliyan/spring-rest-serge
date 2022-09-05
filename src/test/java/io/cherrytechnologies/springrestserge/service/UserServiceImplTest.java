package io.cherrytechnologies.springrestserge.service;

import io.cherrytechnologies.springrestserge.exceptions.UserNotFoundException;
import io.cherrytechnologies.springrestserge.io.entity.UserEntity;
import io.cherrytechnologies.springrestserge.io.repository.UserRepository;
import io.cherrytechnologies.springrestserge.shared.dto.UserDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceImplTest {

    @InjectMocks
    UserServiceImpl userService;

    @Mock
    UserRepository userRepository;

    UserEntity entity;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        entity = new UserEntity();
        entity.setId(UUID.randomUUID());
        entity.setFirstName("James");
        entity.setLastName("Potter");
        entity.setEmail("jamespotter@gmail.com");
        entity.setEncryptedPassword("asdfasiuhdf325345");
        entity.setEmailVerificationStatus(true);
        entity.setEmailVerificationToken("asdfkhjkq3j4thwrekj");
    }

    @Test
    final void Test_get_user_by_id() {
        when(userRepository.findById(any())).thenReturn(Optional.of(entity));

        UserDto userDto = userService.getUserById(entity.getId());

        verify(userRepository, times(1)).findById(any());

        assertNotNull(userDto);
        assertEquals(userDto.getUserId(), entity.getId());
        assertEquals(userDto.getFirstName(), entity.getFirstName());
        assertEquals(userDto.getLastName(), entity.getLastName());
        assertEquals(userDto.getEmail(), entity.getEmail());
        assertEquals(userDto.getEmailVerificationStatus(), entity.getEmailVerificationStatus());
        assertEquals(userDto.getEmailVerificationToken(), entity.getEmailVerificationToken());
        assertEquals(userDto.getEncryptedPassword(), entity.getEncryptedPassword());

        assertNull(userDto.getPassword());
    }

    @Test
    final void Test_get_user_by_id_throw_exception_when_no_user_found() {
        when(userRepository.findById(UUID.randomUUID())).thenReturn(Optional.empty());


        assertThrows(UserNotFoundException.class,
                () -> userService.getUserById(UUID.randomUUID())
        );
    }
}