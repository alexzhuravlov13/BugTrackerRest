package com.zhuravlov.bugtracker.rest.repository;


import com.zhuravlov.bugtracker.rest.model.RoleEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RepositoryRestResource(path = "roles")
public interface RoleRepository extends CrudRepository<RoleEntity, Integer> {

    @Override
    <S extends RoleEntity> S save(S entity);

    @Override
    List<RoleEntity> findAll();

    @Query("from RoleEntity where name = :name")
    RoleEntity findByName(@Param("name") String name);

    @Transactional
    default RoleEntity createRoleIfNotFound(String name) {
        RoleEntity roleEntity = findByName(name);
        if (roleEntity == null) {
            roleEntity = new RoleEntity(name);
            save(roleEntity);
        }
        return roleEntity;
    }
}
