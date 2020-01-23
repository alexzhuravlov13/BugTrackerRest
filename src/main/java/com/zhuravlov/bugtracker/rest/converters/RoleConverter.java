package com.zhuravlov.bugtracker.rest.converters;

import com.zhuravlov.bugtracker.rest.model.RoleEntity;
import com.zhuravlov.bugtracker.rest.model.UserEntity;
import com.zhuravlov.bugtracker.rest.model.response.RoleResponse;
import com.zhuravlov.bugtracker.rest.model.response.UserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Component
@Slf4j
public class RoleConverter implements Converter<RoleEntity, RoleResponse> {

    @Autowired
    private UserConverter userConverter;

    @Override
    public RoleResponse convert(RoleEntity role) {
        Set<UserEntity> userEntities = role.getUsers();
        Set<UserResponse> users = userEntities.stream().map(userEntity -> userConverter.convert(userEntity)).collect(Collectors.toSet());

        RoleResponse roleResponse = new RoleResponse(role.getId(), role.getName(), users);
        log.info("Successfully _______ converted RoleEntity to RoleResponse id = {}", role.getId());
        return roleResponse;
    }
}
