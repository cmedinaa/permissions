package com.cmedinaa.permissions.server.services;


import com.cmedinaa.permissions.server.entities.User;

import java.util.List;

public interface UserService {

    /**
     *
     * @return
     */
    public List<User> getUsers();

    /**
     *
     * @return
     */
    public User create(User user);
}
