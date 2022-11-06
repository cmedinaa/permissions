package com.cmedinaa.permissions.server.repositories;

import com.cmedinaa.permissions.server.entities.Group;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends PagingAndSortingRepository<Group, Long> {
}
