package com.cmedinaa.permissions.server.conversion.builders;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class AbstractFactory<T, K> implements Factory<T, K> {

    @Override
    abstract public T toEntity(K dto);

    @Override
    abstract public K toDTO(T entity);

    @Override
    public List<T> toEntities(List<K> dtos) {
        return Optional.ofNullable(dtos)
                .orElse(Collections.emptyList())
                .stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<K> toDTOs(List<T> entities) {
        return Optional.ofNullable(entities)
                .orElse(Collections.emptyList())
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
