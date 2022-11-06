package com.cmedinaa.permissions.server.conversion.mappers;

import com.cmedinaa.permissions.server.conversion.dto.PermissionDTO;
import com.cmedinaa.permissions.server.entities.Permission;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PermissionMapper {

    /**
     *
     * @param dto
     * @return
     */
    public Permission toEntity(PermissionDTO dto);

    /**
     *
     * @param entity
     * @return
     */
    public PermissionDTO toDTO(Permission entity);


    /**
     *
     * @return
     */
    public List<Permission> toEntities(List<PermissionDTO> dtos);

    /**
     *
     * @param entities
     * @return
     */
    public List<PermissionDTO> toDTOs(List<Permission> entities);
}
