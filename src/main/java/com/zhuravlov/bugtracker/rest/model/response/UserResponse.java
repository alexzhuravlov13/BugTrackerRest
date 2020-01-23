package com.zhuravlov.bugtracker.rest.model.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
public class UserResponse {

    private int userId;

    private String firstName;

    private String lastName;

    private String email;

    @ManyToMany
    private Set<String> roles;

}
