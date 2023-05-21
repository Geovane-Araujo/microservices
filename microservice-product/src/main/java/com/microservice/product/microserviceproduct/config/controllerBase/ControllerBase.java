package com.microservice.product.microserviceproduct.config.controllerBase;

import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ControllerBase<T,ID> {


    @PostMapping
    @Transactional
    public T save(@RequestBody T obj);

    @PutMapping("{id}")
    @Transactional
    public T update(@RequestBody T obj,@PathVariable ID id);

    @DeleteMapping("{id}")
    @Transactional
    public void delete(@PathVariable(value = "id", required = true) ID id);

    @GetMapping("{id}")
    @Transactional
    public T get(@PathVariable(value = "id", required = true) ID id);

    @GetMapping
    @Transactional
    public List<T> getAll(@RequestBody RequestEntities obj);
}
