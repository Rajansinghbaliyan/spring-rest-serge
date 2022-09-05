package io.cherrytechnologies.springrestserge.shared.mapper;

import io.cherrytechnologies.springrestserge.shared.dto.UserDto;
import io.cherrytechnologies.springrestserge.shared.dto.UserDtoBuilder;
import io.cherrytechnologies.springrestserge.ui.model.request.CreateUserDetailRequestModel;
import io.cherrytechnologies.springrestserge.ui.model.response.UserRest;

public class UserMapper {
    public static UserDto requestModelToDto(CreateUserDetailRequestModel requestModel) {
        return new UserDtoBuilder()
                .setFirstName(requestModel.getFirstName())
                .setLastName(requestModel.getLastName())
                .setPassword(requestModel.getPassword())
                .setEmail(requestModel.getEmail())
                .build();
    }

    public static UserRest userDtoToUserRest(UserDto dto) {
        return new UserRest()
                .setUserId(dto.getUserId())
                .setFirstName(dto.getFirstName())
                .setLastName(dto.getLastName())
                .setEmail(dto.getEmail());
    }
}
