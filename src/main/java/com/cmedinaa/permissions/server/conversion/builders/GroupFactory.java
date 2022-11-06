package com.cmedinaa.permissions.server.conversion.builders;

import com.cmedinaa.permissions.server.conversion.dto.GroupDTO;
import com.cmedinaa.permissions.server.conversion.mappers.CoreMapper;
import com.cmedinaa.permissions.server.conversion.mappers.CoreMapperImpl;
import com.cmedinaa.permissions.server.entities.Group;

import java.util.List;

public class GroupFactory extends AbstractFactory<Group, GroupDTO> {
    private final CoreMapper coreMapper;

    public GroupFactory() {
        this.coreMapper = new CoreMapperImpl();
    }


    @Override
    public Group toEntity(GroupDTO dto) {
        return coreMapper.toEntity(dto);
    }

    @Override
    public GroupDTO toDTO(Group entity) {
        return coreMapper.toDTO(entity);
    }

    @Override
    public List<Group> toEntities(List<GroupDTO> dtos) {
        return super.toEntities(dtos);
    }

    @Override
    public List<GroupDTO> toDTOs(List<Group> entities) {
        return super.toDTOs(entities);
    }
}
