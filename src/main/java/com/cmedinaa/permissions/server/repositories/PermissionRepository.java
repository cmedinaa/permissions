package com.cmedinaa.permissions.server.repositories;

import com.cmedinaa.permissions.server.entities.Permission;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends PagingAndSortingRepository<Permission, Long> {
}
