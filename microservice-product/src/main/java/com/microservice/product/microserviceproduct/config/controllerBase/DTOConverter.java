package com.microservice.product.microserviceproduct.config.controllerBase;

import com.microservice.product.microserviceproduct.dto.category.CategoryDto;
import com.microservice.product.microserviceproduct.dto.product.ProductDto;
import com.microservice.product.microserviceproduct.model.category.CategoryEntity;
import com.microservice.product.microserviceproduct.model.product.ProductEntity;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;

public class DTOConverter<DTO,ENTITY> {

    Class<?> entityClass;
    Class<?> dtoClass;

    public DTOConverter(Class<?> entityClass, Class<?> dtoClass){
        this.entityClass = entityClass;
        this.dtoClass = dtoClass;
    }
    public ENTITY toEntity(DTO dto){
        var obj = getConstructor(this.entityClass);
        BeanUtils.copyProperties(dto,obj);
        return (ENTITY) obj;
    }

    public  DTO toDto(ENTITY entity){
        var obj = getConstructor(this.dtoClass);
        BeanUtils.copyProperties(entity,obj);
        return (DTO) obj;
    }

    private Object getConstructor(Class clazz){
        try {
            Constructor<?> constructor = clazz.getDeclaredConstructor();
            return constructor.newInstance();
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
