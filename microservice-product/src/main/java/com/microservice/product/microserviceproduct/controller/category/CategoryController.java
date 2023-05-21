package com.microservice.product.microserviceproduct.controller.category;

import com.microservice.product.microserviceproduct.config.controllerBase.ControllerBase;
import com.microservice.product.microserviceproduct.config.controllerBase.DTOConverter;
import com.microservice.product.microserviceproduct.config.controllerBase.RequestEntities;
import com.microservice.product.microserviceproduct.dto.category.CategoryDto;
import com.microservice.product.microserviceproduct.model.category.CategoryEntity;
import com.microservice.product.microserviceproduct.repository.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@RestController
@RequestMapping("category")
public class CategoryController implements ControllerBase<CategoryDto, Integer> {

    @Autowired
    CategoryRepository repository;

    DTOConverter<CategoryDto, CategoryEntity> dtoConverter = new DTOConverter(CategoryEntity.class, CategoryDto.class);

    @Override
    public CategoryDto save(CategoryDto obj) {
        CategoryEntity entity = dtoConverter.toEntity(obj);;
        entity = repository.save(entity);
        return dtoConverter.toDto(entity);
    }

    @Override
    public CategoryDto update(CategoryDto obj, Integer integer) {
        //repository.findById(integer).map(item -> );
        return null;
    }

    @Override
    public void delete(Integer integer) {
        repository.deleteById(integer);
    }

    @Override
    public CategoryDto get(Integer integer) {
        var entity = repository.findById(integer);
        AtomicReference<CategoryDto> dto = new AtomicReference<>(new CategoryDto());
        entity.ifPresent(item -> {
            dto.set(dtoConverter.toDto(item));
        });
        return dto.get();
    }

    @Override
    public List<CategoryDto> getAll(RequestEntities obj) {
        var list = new ArrayList<CategoryDto>();
        repository.findAll().forEach(item -> {
            list.add(dtoConverter.toDto(item));
        });
        return list;
    }
}
