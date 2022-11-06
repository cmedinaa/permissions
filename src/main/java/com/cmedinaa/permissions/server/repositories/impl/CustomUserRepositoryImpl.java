package com.cmedinaa.permissions.server.repositories.impl;

import com.cmedinaa.permissions.server.repositories.CustomUserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CustomUserRepositoryImpl implements CustomUserRepository {
    @PersistenceContext
    private EntityManager em;


}
