package com.microservice.product.microserviceproduct.dto.category;

import com.microservice.product.microserviceproduct.config.controllerBase.DTOConverter;
import com.microservice.product.microserviceproduct.dto.product.ProductDto;
import com.microservice.product.microserviceproduct.model.category.CategoryEntity;
import com.microservice.product.microserviceproduct.model.product.ProductEntity;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;


@Data
public class CategoryDto{
    public Integer id;
    public String description;

}
