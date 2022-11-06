package com.cmedinaa.permissions.server.repositories;

import com.cmedinaa.permissions.server.entities.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long>, CustomUserRepository {

    /**
     *
     * @param loginName
     * @return
     */
    User findByLoginName(String loginName);
}
