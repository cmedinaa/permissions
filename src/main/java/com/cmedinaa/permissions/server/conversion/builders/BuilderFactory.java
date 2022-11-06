package com.cmedinaa.permissions.server.conversion.builders;

public interface BuilderFactory {

    /**
     *
     * @param clazz
     * @return
     */
    public Factory forClass(Class clazz);
}
