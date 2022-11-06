package com.cmedinaa.permissions.server.conversion.builders;

import com.cmedinaa.permissions.server.conversion.dto.UserDTO;
import com.cmedinaa.permissions.server.conversion.mappers.CoreMapper;
import com.cmedinaa.permissions.server.conversion.mappers.CoreMapperImpl;
import com.cmedinaa.permissions.server.entities.User;

import java.util.List;

public class UserFactory extends AbstractFactory<User, UserDTO> {
    private final CoreMapper coreMapper;

    public UserFactory() {
        coreMapper = new CoreMapperImpl();
    }

    @Override
    public User toEntity(UserDTO dto) {
        return coreMapper.toEntity(dto);
    }

    @Override
    public UserDTO toDTO(User entity) {
        return coreMapper.toDTO(entity);
    }

    @Override
    public List<User> toEntities(List<UserDTO> dtos) {
        return super.toEntities(dtos);
    }

    @Override
    public List<UserDTO> toDTOs(List<User> entities) {
        return super.toDTOs(entities);
    }
}
