package com.zhuravlov.bugtracker.rest.repository;

import com.zhuravlov.bugtracker.rest.model.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    @Override
    <S extends UserEntity> S save(S entity);

    @Override
    Optional<UserEntity> findById(Integer integer);

    @Override
    List<UserEntity> findAll();

    @Override
    void deleteById(Integer integer);

    @Query("from UserEntity where email = :email")
    UserEntity findByEmail(@Param("email") String email);

}
