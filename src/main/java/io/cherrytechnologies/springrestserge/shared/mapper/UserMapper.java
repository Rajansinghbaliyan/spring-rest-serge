package io.cherrytechnologies.springrestserge.shared.mapper;

import io.cherrytechnologies.springrestserge.io.entity.UserEntity;
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

    public static UserEntity dtoToEntity(UserDto dto){
        UserEntity entity = new UserEntity();
        entity.setUserId(dto.getUserId());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setEmail(dto.getEmail());
        entity.setEncryptedPassword(dto.getEncryptedPassword());
        entity.setEmailVerificationToken(dto.getEmailVerificationToken());
        entity.setEmailVerificationStatus(dto.getEmailVerificationStatus());
        return entity;
    }

    public static UserDto entityToDto(UserEntity entity){
        return new UserDtoBuilder()
                .setUserId(entity.getUserId())
                .setFirstName(entity.getFirstName())
                .setLastName(entity.getLastName())
                .setEmail(entity.getEmail())
                .setEncryptedPassword(entity.getEncryptedPassword())
                .setEmailVerificationStatus(entity.getEmailVerificationStatus())
                .setEmailVerificationToken(entity.getEmailVerificationToken())
                .build();

    }
}
