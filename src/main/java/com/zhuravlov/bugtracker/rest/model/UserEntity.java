package com.zhuravlov.bugtracker.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    @EqualsAndHashCode.Include
    private int userId;

    @NotBlank(message = "first name is required")
    @Column(name = "first_Name")
    @NonNull
    private String firstName;

    @NotBlank(message = "last name is required")
    @Column(name = "last_Name")
    @NonNull
    private String lastName;


    @Email(message = "invalid email format")
    @Column(name = "email", unique = true)
    @NotBlank(message = "email is required")
    @NonNull
    @EqualsAndHashCode.Include
    private String email;

    @ManyToMany
    private List<RoleEntity> roles;

    @NonNull
    @JsonIgnore
    private String password;

    @Transient
    @JsonIgnore
    private String passwordConfirm;


}
