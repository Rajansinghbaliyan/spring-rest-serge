package io.cherrytechnologies.springrestserge.shared.mapper;

import io.cherrytechnologies.springrestserge.shared.dto.UserDto;
import io.cherrytechnologies.springrestserge.shared.dto.UserDtoBuilder;
import io.cherrytechnologies.springrestserge.ui.model.request.CreateUserDetailRequestModel;
import org.junit.jupiter.api.BeforeEach;

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
                .setEmailVerificationStatus("false")
                .setEmailVerificationToken("asdkfjladksfj4235fre")
                .build();

        userDetailRequestModel = new CreateUserDetailRequestModel()
                .setFirstName("James")
                .setLastName("Potter")
                .setEmail("jamespotter@gmail.com")
                .setPassword("asdkfjklasdfj24352435");
    }
}