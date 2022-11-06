package com.cmedinaa.permissions.server.controllers.impl;

import com.cmedinaa.permissions.server.controllers.PermissionController;
import com.cmedinaa.permissions.server.conversion.components.ConversionFactory;
import com.cmedinaa.permissions.server.conversion.dto.PermissionDTO;
import com.cmedinaa.permissions.server.entities.Permission;
import com.cmedinaa.permissions.server.services.PermissionService;
import org.apache.commons.lang3.exception.ContextedRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@RestController
@RequestMapping("/permissions")
public class PermissionControllerImpl implements PermissionController {
    Logger logger = LoggerFactory.getLogger(PermissionControllerImpl.class);

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private ConversionFactory conversionFactory;

    @Override
    public ResponseEntity<PermissionDTO> create(PermissionDTO permission) {
        return Optional.ofNullable(permission)
                .map(dto -> handleExceptions(() -> conversionFactory.forClass(Permission.class).toEntity(dto)))
                .filter(o -> o.isPresent())
                .map(optional -> (Permission)optional.get())
                .map(entity -> handleExceptions(() -> permissionService.create(entity)))
                .filter(o -> o.isPresent())
                .map(optional -> (Permission)optional.get())
                .map(entity -> handleExceptions(() -> conversionFactory.forClass(Permission.class).toDTO(entity)))
                .filter(o -> o.isPresent())
                .map(dto -> (PermissionDTO)dto.get())
                .map(dto -> ResponseEntity.ok(dto))
                .orElse(ResponseEntity.internalServerError().build())
        ;
    }

    @Override
    @GetMapping("/all")
    public ResponseEntity<List<PermissionDTO>> getPermissions() {
        return Optional.ofNullable(handleExceptions(() -> permissionService.getPermissions()) )
                .filter(o -> o.isPresent())
                .map(optional -> (List<Permission>)optional.get())
                .map(permissions -> handleExceptions(() -> conversionFactory.forClass(Permission.class).toDTOs(permissions) ) )
                .filter(o -> o.isPresent())
                .map(results -> ResponseEntity.ok((List<PermissionDTO>)results.get()))
                .orElse(ResponseEntity.internalServerError().build())
        ;
    }

    /**
     *
     * @param function
     * @return
     */
    private Optional<Object> handleExceptions(Supplier<?> function) {
        try {
            return Optional.ofNullable(function.get());
        }
        catch (ContextedRuntimeException cte) {
            logger.error(cte.getMessage(), cte);
            return Optional.empty();
        }
        catch (UnsupportedOperationException uoe) {
            logger.error(uoe.getMessage(), uoe);
            return Optional.empty();
        }
        catch (Exception e) {
            logger.error("Something went wrong ", e);
            return Optional.empty();
        }
    }
}
