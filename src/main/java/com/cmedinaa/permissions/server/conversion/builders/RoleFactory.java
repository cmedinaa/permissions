package com.cmedinaa.permissions.server.conversion.builders;

import com.cmedinaa.permissions.server.conversion.dto.RoleDTO;
import com.cmedinaa.permissions.server.conversion.mappers.CoreMapper;
import com.cmedinaa.permissions.server.conversion.mappers.CoreMapperImpl;
import com.cmedinaa.permissions.server.entities.Role;

import java.util.List;

public class RoleFactory extends AbstractFactory<Role, RoleDTO> {
    private final CoreMapper coreMapper;

    public RoleFactory() {
        coreMapper = new CoreMapperImpl();
    }

    @Override
    public Role toEntity(RoleDTO dto) {
        return coreMapper.toEntity(dto);
    }

    @Override
    public RoleDTO toDTO(Role entity) {
        return coreMapper.toDTO(entity);
    }

    @Override
    public List<Role> toEntities(List<RoleDTO> dtos) {
        return super.toEntities(dtos);
    }

    @Override
    public List<RoleDTO> toDTOs(List<Role> entities) {
        return super.toDTOs(entities);
    }
}
