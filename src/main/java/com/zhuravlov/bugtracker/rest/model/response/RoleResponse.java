package com.zhuravlov.bugtracker.rest.model.response;

import lombok.*;
import java.util.Set;

@Data
@AllArgsConstructor
public class RoleResponse {

    private Long id;

    private String name;

    private Set<UserResponse> users;
}
