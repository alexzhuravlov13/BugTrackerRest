package com.zhuravlov.bugtracker.rest.repository;

import com.zhuravlov.bugtracker.rest.model.MessageEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "messages")
public interface MessageRepository extends CrudRepository<MessageEntity, Integer> {

    @Override
    <S extends MessageEntity> S save(S entity);

    @Override
    void deleteById(Integer integer);
}
