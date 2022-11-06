package com.cmedinaa.permissions.server.services.impl;

import com.cmedinaa.permissions.server.entities.Permission;
import com.cmedinaa.permissions.server.repositories.PermissionRepository;
import com.cmedinaa.permissions.server.services.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public List<Permission> getPermissions() {
        return StreamSupport.stream(permissionRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @Override
    public Permission create(Permission permission) {
        return null;
    }
}
