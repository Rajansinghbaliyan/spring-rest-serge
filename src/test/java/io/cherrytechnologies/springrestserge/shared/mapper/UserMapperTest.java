package io.cherrytechnologies.springrestserge.shared.mapper;

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
}