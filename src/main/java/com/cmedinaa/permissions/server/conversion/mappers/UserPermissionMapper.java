package com.cmedinaa.permissions.server.conversion.mappers;

import com.cmedinaa.permissions.server.conversion.dto.UserPermissionDTO;
import com.cmedinaa.permissions.server.entities.UserPermission;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING
        , uses = {PermissionMapper.class}
)
public interface UserPermissionMapper {
    @Mappings({
        @Mapping(target = "user", expression = "java(null)")
    })
    public abstract UserPermission toEntity(UserPermissionDTO dto);

    /**
     *
     * @param entity
     * @return
     */
    @Mappings({
        @Mapping(target = "user", expression = "java(null)")
    })
    public abstract UserPermissionDTO toDTO(UserPermission entity);
}
