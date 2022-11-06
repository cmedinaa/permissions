package com.cmedinaa.permissions.server.conversion.dto;

import com.cmedinaa.permissions.server.entities.Hierarchy;

import java.util.List;

public class RoleDTO extends Hierarchy<RoleDTO> {
    private Long id;
    private String name;
    private List<UserDTO> users;
    private List<GroupDTO> groups;
    private List<RolePermissionDTO> rolePermissions;

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

    public List<GroupDTO> getGroups() {
        return groups;
    }

    public void setGroups(List<GroupDTO> groups) {
        this.groups = groups;
    }

    public List<RolePermissionDTO> getRolePermissions() {
        return rolePermissions;
    }

    public void setRolePermissions(List<RolePermissionDTO> rolePermissions) {
        this.rolePermissions = rolePermissions;
    }
}
