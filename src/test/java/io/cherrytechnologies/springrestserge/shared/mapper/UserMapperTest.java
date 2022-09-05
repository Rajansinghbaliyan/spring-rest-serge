package io.cherrytechnologies.springrestserge.shared.mapper;

import io.cherrytechnologies.springrestserge.io.entity.UserEntity;
import io.cherrytechnologies.springrestserge.shared.dto.UserDto;
import io.cherrytechnologies.springrestserge.shared.dto.UserDtoBuilder;
import io.cherrytechnologies.springrestserge.ui.model.request.CreateUserDetailRequestModel;
import io.cherrytechnologies.springrestserge.ui.model.response.UserRest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class UserMapperTest {

    UserDto userDto;

    CreateUserDetailRequestModel userDetailRequestModel;

    UserEntity entity;

    @BeforeEach
    void setUp() {
        userDto = new UserDtoBuilder()
                .setUserId(UUID.randomUUID())
                .setFirstName("James")
                .setLastName("Potter")
                .setEmail("jamespotter@gmail.com")
                .setPassword("sdafasdf97sdf89")
                .setEmailVerificationStatus(false)
                .setEmailVerificationToken("asdkfjladksfj4235fre")
                .build();

        userDetailRequestModel = new CreateUserDetailRequestModel()
                .setFirstName("James")
                .setLastName("Potter")
                .setEmail("jamespotter@gmail.com")
                .setPassword("asdkfjklasdfj24352435");

        entity = new UserEntity();
        entity.setId(UUID.randomUUID());
        entity.setFirstName("James");
        entity.setLastName("Potter");
        entity.setEmail("jamespotter@gmail.com");
        entity.setEncryptedPassword("asdfasdkfhj435435");
        entity.setEmailVerificationStatus(false);
        entity.setEmailVerificationToken("asdfasdf345gfsdfg456");
    }

    @Test
    final void Test_request_model_to_dto(){
        UserDto userDto1 = UserMapper.requestModelToDto(userDetailRequestModel);

        assertNull(userDto1.getUserId());
        assertNull(userDto1.getEmailVerificationStatus());
        assertNull(userDto1.getEmailVerificationToken());
        assertNull(userDto1.getEncryptedPassword());

        assertEquals(userDto1.getFirstName(), userDetailRequestModel.getFirstName());
        assertEquals(userDto1.getLastName(), userDetailRequestModel.getLastName());
        assertEquals(userDto1.getEmail(), userDetailRequestModel.getEmail());
        assertEquals(userDto1.getPassword(), userDetailRequestModel.getPassword());
    }

    @Test
    final void Test_dto_to_user_rest(){
        UserRest userRest = UserMapper.userDtoToUserRest(userDto);

        assertEquals(userRest.getUserId(), userDto.getUserId());
        assertEquals(userRest.getFirstName(), userDto.getFirstName());
        assertEquals(userRest.getLastName(), userDto.getLastName());
        assertEquals(userRest.getEmail(), userDto.getEmail());
    }

    @Test
    final void Test_dto_to_entity(){
        UserEntity entity = UserMapper.dtoToEntity(userDto);

        assertNotNull(entity);

        assertEquals(entity.getId(),userDto.getUserId());
        assertEquals(entity.getFirstName(), userDto.getFirstName());
        assertEquals(entity.getLastName(), userDto.getLastName());
        assertEquals(entity.getEmail(), userDto.getEmail());
        assertEquals(entity.getEmailVerificationStatus(), userDto.getEmailVerificationStatus());
        assertEquals(entity.getEmailVerificationToken(), userDto.getEmailVerificationToken());
        assertEquals(entity.getEncryptedPassword(), userDto.getEncryptedPassword());
    }

    @Test
    final void Test_entity_to_dto(){
        UserDto dto = UserMapper.entityToDto(entity);

        assertNotNull(dto);

        assertEquals(entity.getId(),dto.getUserId());
        assertEquals(entity.getFirstName(), dto.getFirstName());
        assertEquals(entity.getLastName(), dto.getLastName());
        assertEquals(entity.getEmail(), dto.getEmail());
        assertEquals(entity.getEmailVerificationStatus(), dto.getEmailVerificationStatus());
        assertEquals(entity.getEmailVerificationToken(), dto.getEmailVerificationToken());
        assertEquals(entity.getEncryptedPassword(), dto.getEncryptedPassword());

    }
}