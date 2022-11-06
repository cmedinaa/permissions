package com.cmedinaa.permissions.server.services;

import com.cmedinaa.permissions.server.entities.Permission;

import java.util.List;

public interface PermissionService {

    /**
     *
     * @return
     */
    public List<Permission> getPermissions();

    /**
     *
     * @param permission
     * @return
     */
    public Permission create(Permission permission);
}
