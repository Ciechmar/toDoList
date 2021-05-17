package com.ciechmar.controller;

import com.ciechmar.model.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RepositoryRestController
class TaskController {
    private final TaskRepository repository;
    private final Logger logger = LoggerFactory.getLogger(TaskController.class);

    TaskController(TaskRepository repository) {
        this.repository = repository;
    }

    //    ResponseEntity<List<Task>> readAllTasks() {
//    @RequestMapping (method = RequestMethod.GET , path = "/tasks" , params = {"!sort", "!page", "!size"}) //methof- GET domyślne -można pominąć
    @GetMapping(value = "/tasks" ,  params = {"!sort", "!page", "!size"})
    ResponseEntity<?> readAllTasks() {
        logger.warn("Exposing all the tasks!");
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/tasks")
    ResponseEntity<?> readAllTasks(Pageable page) {
        logger.info("Custom pageable");
        return ResponseEntity.ok(repository.findAll(page));
    }
}

