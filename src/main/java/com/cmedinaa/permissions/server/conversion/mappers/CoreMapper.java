package com.cmedinaa.permissions.server.conversion.mappers;

import com.cmedinaa.permissions.server.conversion.dto.GroupDTO;
import com.cmedinaa.permissions.server.conversion.dto.RoleDTO;
import com.cmedinaa.permissions.server.conversion.dto.UserDTO;
import com.cmedinaa.permissions.server.entities.Group;
import com.cmedinaa.permissions.server.entities.Role;
import com.cmedinaa.permissions.server.entities.User;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING ,
        uses = {UserPermissionMapper.class, GroupPermissionMapper.class, RolePermissionMapper.class}
)
public abstract class CoreMapper {
    //****************************************
    //      USERS
    //****************************************
    @Mappings({
            @Mapping(target = "groups", qualifiedByName = {"groupsToEntityWithoutRelations"}),
            @Mapping(target = "roles", qualifiedByName = {"rolesToEntityWithoutRelations"})
    })
    public abstract User toEntity(UserDTO dto);

    /**
     *
     * @param entity
     * @return
     */
    @Mappings({
            @Mapping(target = "groups", qualifiedByName = { "groupsToDTOWithoutRelations"}),
            @Mapping(target = "roles", qualifiedByName = { "rolesToDTOWithoutRelations"})
    })
    public abstract UserDTO toDTO(User entity);

     /**
     *
     * @param dto
     * @return
     */
    @Mappings({
            //@Mapping(target = "userPermissions", expression = "java(null)"),
            @Mapping(target = "groups", expression = "java(null)"),
            @Mapping(target = "roles", expression = "java(null)")
    })
    @Named("usersToEntityWithoutRelations")
    public abstract User usersToEntityWithoutRelations(UserDTO dto);


    /**
     *
     * @param entity
     * @return
     */
    @Mappings({
            //@Mapping(target = "userPermissions", expression = "java(null)"),
            @Mapping(target = "groups", expression = "java(null)"),
            @Mapping(target = "roles", expression = "java(null)")
    })
    @Named("usersToDTOWithoutRelations")
    public abstract UserDTO usersToDTOWithoutRelations(User entity);


    //****************************************
    //      ROLES
    //****************************************
    @Mappings({
            @Mapping(target = "users", qualifiedByName = { "usersToEntityWithoutRelations"}),
            @Mapping(target = "groups", qualifiedByName = { "groupsToEntityWithoutRelations"})
    })
    public abstract Role toEntity(RoleDTO dto);

    /**
     *
     * @param entity
     * @return
     */
    @Mappings({
            @Mapping(target = "users", qualifiedByName = { "usersToDTOWithoutRelations"}),
            @Mapping(target = "groups", qualifiedByName = { "groupsToDTOWithoutRelations"})
    })
    public abstract RoleDTO toDTO(Role entity);

    /**
     *
     * @param dto
     * @return
     */
    @Mappings({
            //@Mapping(target = "rolePermissions", expression = "java(null)"),
            @Mapping(target = "users", expression = "java(null)"),
            @Mapping(target = "groups", expression = "java(null)"),
            @Mapping(target = "father", expression = "java(null)"),
            @Mapping(target = "children", expression = "java(null)")
    })
    @Named("rolesToEntityWithoutRelations")
    public abstract Role rolesToEntityWithoutRelations(RoleDTO dto);


    /**
     *
     * @param entity
     * @return
     */
    @Mappings({
            //@Mapping(target = "rolePermissions", expression = "java(null)"),
            @Mapping(target = "users", expression = "java(null)"),
            @Mapping(target = "groups", expression = "java(null)"),
            @Mapping(target = "father", expression = "java(null)"),
            @Mapping(target = "children", expression = "java(null)")
    })
    @Named("rolesToDTOWithoutRelations")
    public abstract RoleDTO rolesToDTOWithoutRelations(Role entity);

    //****************************************
    //      GROUPS
    //****************************************

    @Mappings({
            @Mapping(target = "users", qualifiedByName = { "usersToEntityWithoutRelations"}),
            @Mapping(target = "roles", qualifiedByName = { "rolesToEntityWithoutRelations"})
    })
    public abstract Group toEntity(GroupDTO dto);

    /**
     *
     * @param entity
     * @return
     */
    @Mappings({
            @Mapping(target = "users", qualifiedByName = { "usersToDTOWithoutRelations"}),
            @Mapping(target = "roles", qualifiedByName = { "rolesToDTOWithoutRelations"})
    })
    public abstract GroupDTO toDTO(Group entity);


    /**
     *
     * @param dto
     * @return
     */
    @Mappings({
            //@Mapping(target = "groupPermissions", expression = "java(null)"),
            @Mapping(target = "users", expression = "java(null)"),
            @Mapping(target = "roles", expression = "java(null)"),
            @Mapping(target = "father", expression = "java(null)"),
            @Mapping(target = "children", expression = "java(null)")
    })
    @Named("groupsToEntityWithoutRelations")
    public abstract Group groupsToEntityWithoutRelations(GroupDTO dto);


    /**
     *
     * @param entity
     * @return
     */
    @Mappings({
            //@Mapping(target = "groupPermissions", expression = "java(null)"),
            @Mapping(target = "users", expression = "java(null)"),
            @Mapping(target = "roles", expression = "java(null)"),
            @Mapping(target = "father", expression = "java(null)"),
            @Mapping(target = "children", expression = "java(null)")
    })
    @Named("groupsToDTOWithoutRelations")
    public abstract GroupDTO groupsToDTOWithoutRelations(Group entity);
}
