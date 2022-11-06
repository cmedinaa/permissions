package com.cmedinaa.permissions.server.exceptions;

public enum PermissionExceptions implements PermissionException {
    FACTORY_NOT_IMPLEMENTED;

    @Override
    public String getName() {
        return name();
    }
}
