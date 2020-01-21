package com.zhuravlov.bugtracker.rest.repository;

import com.zhuravlov.bugtracker.rest.model.TicketEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(path = "tickets", collectionResourceRel = "tickets")
public interface TicketRepository extends CrudRepository<TicketEntity, Integer> {
    @Override
    <S extends TicketEntity> S save(S entity);

    @Override
    Optional<TicketEntity> findById(Integer integer);

    @Override
    List<TicketEntity> findAll();

    @Override
    void deleteById(Integer integer);

}
