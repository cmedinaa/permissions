package com.cmedinaa.permissions.server.conversion.builders;

import com.cmedinaa.permissions.server.conversion.dto.PermissionDTO;
import com.cmedinaa.permissions.server.conversion.mappers.PermissionMapper;
import com.cmedinaa.permissions.server.conversion.mappers.PermissionMapperImpl;
import com.cmedinaa.permissions.server.entities.Permission;

import java.util.List;

public class PermissionFactory extends AbstractFactory<Permission, PermissionDTO> {
    private final PermissionMapper permissionMapper;

    public PermissionFactory() {
        permissionMapper = new PermissionMapperImpl();
    }

    @Override
    public Permission toEntity(PermissionDTO dto) {
        return permissionMapper.toEntity(dto);
    }

    @Override
    public PermissionDTO toDTO(Permission entity) {
        PermissionMapperImpl permissionMapper = new PermissionMapperImpl();
        return permissionMapper.toDTO(entity);
    }

    @Override
    public List<Permission> toEntities(List<PermissionDTO> dtos) {
        return super.toEntities(dtos);
    }

    @Override
    public List<PermissionDTO> toDTOs(List<Permission> entities) {
        return super.toDTOs(entities);
    }
}
