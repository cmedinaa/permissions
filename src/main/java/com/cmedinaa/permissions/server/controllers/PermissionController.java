package com.cmedinaa.permissions.server.controllers;

import com.cmedinaa.permissions.server.conversion.dto.PermissionDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PermissionController {

    /**
     *
     * @param permission
     * @return
     */
    public ResponseEntity<PermissionDTO> create(PermissionDTO permission);


    /**
     *
     * @return
     */
    public ResponseEntity<List<PermissionDTO>> getPermissions();
}
