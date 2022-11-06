package com.cmedinaa.permissions.server.conversion.mappers;

import com.cmedinaa.permissions.server.conversion.dto.GroupPermissionDTO;
import com.cmedinaa.permissions.server.entities.GroupPermission;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING
        , uses = {PermissionMapper.class}
)
public interface GroupPermissionMapper {
    @Mappings({
        @Mapping(target = "group", expression = "java(null)")
    })
    public abstract GroupPermission toEntity(GroupPermissionDTO dto);

    /**
     *
     * @param entity
     * @return
     */
    @Mappings({
        @Mapping(target = "group", expression = "java(null)")
    })
    public abstract GroupPermissionDTO toDTO(GroupPermission entity);
}
