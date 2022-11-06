package com.cmedinaa.permissions.server.conversion.dto;

import java.util.List;

public class UserDTO {
    private Long id;
    private String name;
    private List<UserPermissionDTO> userPermissions;
    private List<GroupDTO> groups;
    private List<RoleDTO> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserPermissionDTO> getUserPermissions() {
        return userPermissions;
    }

    public void setUserPermissions(List<UserPermissionDTO> userPermissions) {
        this.userPermissions = userPermissions;
    }

    public List<GroupDTO> getGroups() {
        return groups;
    }

    public void setGroups(List<GroupDTO> groups) {
        this.groups = groups;
    }

    public List<RoleDTO> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDTO> roles) {
        this.roles = roles;
    }
}
