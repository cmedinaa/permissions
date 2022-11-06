package com.cmedinaa.permissions.server.conversion.builders;

import java.util.List;

public interface Factory<T, K> {

    /**
     *
     * @return
     */
    public T toEntity(K dto);

    /**
     *
     * @param entity
     * @return
     */
    public K toDTO(T entity);


    /**
     *
     * @return
     */
    public List<T> toEntities(List<K> dtos);

    /**
     *
     * @param entities
     * @return
     */
    public List<K> toDTOs(List<T> entities);
}
