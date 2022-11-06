package com.cmedinaa.permissions.server.conversion.mappers;

import com.cmedinaa.permissions.server.conversion.dto.RolePermissionDTO;
import com.cmedinaa.permissions.server.entities.RolePermission;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING
        , uses = {PermissionMapper.class}
)
public interface RolePermissionMapper {
    @Mappings({
        @Mapping(target = "role", expression = "java(null)")
    })
    public abstract RolePermission toEntity(RolePermissionDTO dto);

    /**
     *
     * @param entity
     * @return
     */
    @Mappings({
        @Mapping(target = "role", expression = "java(null)")
    })
    public abstract RolePermissionDTO toDTO(RolePermission entity);
}
