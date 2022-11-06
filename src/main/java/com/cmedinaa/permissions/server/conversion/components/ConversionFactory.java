package com.cmedinaa.permissions.server.conversion.components;

import com.cmedinaa.permissions.server.conversion.builders.*;
import com.cmedinaa.permissions.server.entities.Group;
import com.cmedinaa.permissions.server.entities.Permission;
import com.cmedinaa.permissions.server.entities.Role;
import com.cmedinaa.permissions.server.entities.User;
import com.cmedinaa.permissions.server.exceptions.ExceptionConstants;
import com.cmedinaa.permissions.server.exceptions.PermissionExceptions;
import org.apache.commons.lang3.exception.ContextedRuntimeException;
import org.springframework.stereotype.Component;


@Component
public class ConversionFactory implements BuilderFactory {

    @Override
    public Factory forClass(Class clazz) {
        if (Group.class.isAssignableFrom(clazz)) {
            return new GroupFactory();
        }

        if (Permission.class.isAssignableFrom(clazz)) {
            return new PermissionFactory();
        }

        if (User.class.isAssignableFrom(clazz)) {
            return new UserFactory();
        }

        if (Role.class.isAssignableFrom(clazz)) {
            return new RoleFactory();
        }

        throw new ContextedRuntimeException(PermissionExceptions.FACTORY_NOT_IMPLEMENTED.getName())
                .addContextValue(ExceptionConstants.clazz, clazz.getName());
    }
}
