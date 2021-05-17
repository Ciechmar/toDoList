package com.ciechmar.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface TaskRepository extends JpaRepository<Task, Integer> {

//    Hiding CRUD methods - delete not allowed
    @Override
    @RestResource(exported = false)
    void delete(Task task);

    @Override
    @RestResource(exported = false)
    void deleteById(Integer integer);


    @RestResource (path="done" ,rel="done")
//    List<Task> findByDoneIsTrue();
    List<Task> findByDone(@Param("state") boolean done);
}
