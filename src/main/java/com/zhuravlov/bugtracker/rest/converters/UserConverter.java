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
public class UserConverter implements Converter<UserEntity, UserResponse> {

    @Autowired
    private RoleConverter roleConverter;

    @Override
    public UserResponse convert(UserEntity user) {
        Set<RoleEntity> roleEntities = user.getRoles();
        Set<String> roles = roleEntities.stream().map(roleEntity -> roleEntity.getName()).collect(Collectors.toSet());
        UserResponse userResponse = new UserResponse(user.getUserId(), user.getFirstName(), user.getLastName(), user.getEmail(), roles);
        log.info("Successfully _______ converted UserEntity to UserResponse id = {}", user.getUserId());
        return userResponse;
    }
}
