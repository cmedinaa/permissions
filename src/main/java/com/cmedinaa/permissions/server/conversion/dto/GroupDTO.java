package com.cmedinaa.permissions.server.conversion.dto;

import com.cmedinaa.permissions.server.entities.Hierarchy;

import java.util.List;

public class GroupDTO extends Hierarchy<GroupDTO>  {
    private Long id;
    private String name;
    private List<UserDTO> users;
    private List<RoleDTO> roles;
    private List<GroupPermissionDTO> groupPermissions;

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

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }

    public List<RoleDTO> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDTO> roles) {
        this.roles = roles;
    }

    public List<GroupPermissionDTO> getGroupPermissions() {
        return groupPermissions;
    }

    public void setGroupPermissions(List<GroupPermissionDTO> groupPermissions) {
        this.groupPermissions = groupPermissions;
    }
}
