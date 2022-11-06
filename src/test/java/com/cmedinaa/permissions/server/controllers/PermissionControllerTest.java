package com.cmedinaa.permissions.server.controllers;

import com.cmedinaa.permissions.server.controllers.impl.PermissionControllerImpl;
import com.cmedinaa.permissions.server.conversion.builders.PermissionFactory;
import com.cmedinaa.permissions.server.conversion.components.ConversionFactory;
import com.cmedinaa.permissions.server.conversion.dto.PermissionDTO;
import com.cmedinaa.permissions.server.entities.Permission;
import com.cmedinaa.permissions.server.services.PermissionService;
import org.mockito.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class PermissionControllerTest {
    @DataProvider(name = "permissions")
    public Object[][] getPermissions() {
        List<Permission> permissions = IntStream.range(1, 3).boxed()
            .map(operand -> {
                Permission permission = new Permission();
                permission.setId((long)operand);
                permission.setCode("CODE");
                return permission;
            })
            .collect(Collectors.toList());

        return new Object[][] {
            { permissions.toArray(new Permission[permissions.size()]) }
        };
    }

    @DataProvider(name = "creation")
    public Object[][] getCreationPermissions() {
        PermissionDTO permissionDTO = new PermissionDTO();
        permissionDTO.setId(1l);
        permissionDTO.setCode("CODE");

        Permission permission = new Permission();
        permission.setId(1l);
        permission.setCode("CODE");

        return new Object[][] {
                { permission, permissionDTO }
        };
    }

    @Mock
    PermissionService permissionService;

    @Mock
    PermissionFactory permissionFactory;

    @Mock
    ConversionFactory conversionFactory;

    @Spy
    @InjectMocks
    PermissionControllerImpl permissionController;

    @BeforeMethod
    void initMocks() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void whenPermissionsEmpty_thenResponseOk() {
        Mockito.when(permissionService.getPermissions()).thenReturn(Collections.emptyList());
        Mockito.when(conversionFactory.forClass(Permission.class)).thenReturn(permissionFactory);

        ResponseEntity<List<PermissionDTO>> response = permissionController.getPermissions();

        Mockito.verify(permissionService, Mockito.times(1)).getPermissions();

        assertNotNull(response);
        assertTrue(response.hasBody());
        assertTrue(response.getStatusCode().equals(HttpStatus.OK));
        assertTrue(response.getBody().isEmpty());
    }

    @Test
    public void whenServiceRisesException_thenResponseInternalServerError() {
        Mockito.when(permissionService.getPermissions()).thenThrow(RuntimeException.class);

        assertDoesNotThrow(() -> {
            ResponseEntity<List<PermissionDTO>> response = permissionController.getPermissions();

            assertNotNull(response);
            assertFalse(response.hasBody());
            assertTrue(response.getStatusCode().equals(HttpStatus.INTERNAL_SERVER_ERROR));
        });
    }

    @Test(dataProvider = "permissions")
    public void whenConversorRisesException_thenResponseInternalServerError(Permission[] permissionArray) {
        List<Permission> permissions = Arrays.asList(permissionArray);

        Mockito.when(permissionService.getPermissions()).thenReturn(permissions);
        Mockito.when(conversionFactory.forClass(Permission.class)).thenReturn(permissionFactory);
        Mockito.when(permissionFactory.toDTOs(permissions)).thenThrow(RuntimeException.class);

        assertDoesNotThrow(() -> {
            ResponseEntity<List<PermissionDTO>> response = permissionController.getPermissions();

            Mockito.verify(permissionService, Mockito.times(1)).getPermissions();

            assertNotNull(response);
            assertFalse(response.hasBody());
            assertTrue(response.getStatusCode().equals(HttpStatus.INTERNAL_SERVER_ERROR));
        });
    }

    @Test
    public void whenCreatePermission_ParameterEmpty_thenResponseInternalServerError(){
        ResponseEntity<PermissionDTO> response = permissionController.create(null);

        Mockito.verify(permissionService, Mockito.never()).create(Mockito.any(Permission.class));

        assertNotNull(response);
        assertFalse(response.hasBody());
        assertTrue(response.getStatusCode().equals(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @Test(dataProvider = "creation")
    public void whenCreatePermission_thenResponseOk(Permission permission, PermissionDTO permissionDTO){
        Mockito.when(conversionFactory.forClass(Permission.class)).thenReturn(permissionFactory);
        Mockito.when(permissionFactory.toEntity(permissionDTO)).thenReturn(permission);
        Mockito.when(permissionService.create(permission)).thenReturn(permission);
        Mockito.when(permissionFactory.toDTO(permission)).thenReturn(permissionDTO);

        ResponseEntity<PermissionDTO> response = permissionController.create(permissionDTO);

        Mockito.verify(permissionService, Mockito.times(1)).create(permission);

        assertNotNull(response);
        assertTrue(response.hasBody());
        assertTrue(response.getStatusCode().equals(HttpStatus.OK));
    }
}
