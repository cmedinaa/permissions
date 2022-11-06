package com.cmedinaa.permissions.server.conversion;

import com.cmedinaa.permissions.server.conversion.builders.PermissionFactory;
import com.cmedinaa.permissions.server.conversion.dto.PermissionDTO;
import com.cmedinaa.permissions.server.entities.Permission;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConverstionTest {

    @DataProvider(name = "permissions")
    public Object[][] getPermissions() {
        Permission permission = new Permission();
        permission.setId(1l);
        permission.setCode("CODE");

        return new Object[][] {
            { permission }
        };
    }

    @DataProvider(name = "permissionsDTO")
    public Object[][] getPermissionsDTO() {
        PermissionDTO permission = new PermissionDTO();
        permission.setId(1l);
        permission.setCode("CODE");

        return new Object[][] {
            { permission }
        };
    }

    @Spy
    PermissionFactory permissionFactory;

    @BeforeMethod
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test(dataProvider = "permissions")
    public void givenPermissionToDto_whenMaps_thenCorrect(Permission permission) {
        PermissionDTO destination = permissionFactory.toDTO(permission);

        assertEquals(permission.getId(), destination.getId());
        assertEquals(permission.getCode(), destination.getCode());
    }

    @Test(dataProvider = "permissionsDTO")
    public void givenDtoToPermission_whenMaps_thenCorrect(PermissionDTO permissionDTO) {
        Permission destination = permissionFactory.toEntity(permissionDTO);

        assertEquals(permissionDTO.getId(), destination.getId());
        assertEquals(permissionDTO.getCode(), destination.getCode());
    }
}
