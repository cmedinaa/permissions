package com.cmedinaa.permissions.server.services;

import com.cmedinaa.permissions.server.entities.Group;

import java.util.List;

public interface GroupService {

    /**
     *
     * @return
     */
    public List<Group> getGroups();
}
