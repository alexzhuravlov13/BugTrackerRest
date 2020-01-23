package com.zhuravlov.bugtracker.rest.controller;

import com.zhuravlov.bugtracker.rest.converters.UserConverter;
import com.zhuravlov.bugtracker.rest.model.response.UserResponse;
import com.zhuravlov.bugtracker.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/users")
public class UsersApiController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserConverter userConverter;

    @GetMapping
    public ResponseEntity<?> getUsers(){
        List<UserResponse> users = userService.getUsers().stream().map(userEntity -> userConverter.convert(userEntity)).collect(Collectors.toList());
        return ResponseEntity.ok(users);
    }


}
