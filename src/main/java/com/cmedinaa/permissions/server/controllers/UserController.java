package com.cmedinaa.permissions.server.controllers;

import com.cmedinaa.permissions.server.conversion.dto.UserDTO;

import java.util.List;

public interface UserController {

    /**
     *
     * @param user
     * @return
     */
    public UserDTO create(UserDTO user);


    /**
     *
     * @return
     */
    public List<UserDTO> getUsers();
}
