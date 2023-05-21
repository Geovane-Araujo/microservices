package com.microservice.product.microserviceproduct.dto.product;

import com.microservice.product.microserviceproduct.model.category.CategoryEntity;
import com.microservice.product.microserviceproduct.model.product.ProductEntity;
import com.microservice.product.microserviceproduct.model.supplier.SupplierEntity;
import lombok.Data;
import org.springframework.beans.BeanUtils;


@Data
public class ProductDto {

    private Integer id;
    private String name;
    private CategoryEntity category;
    private SupplierEntity supplier;

    public static ProductEntity toEntity(ProductDto dto){
        var object = new ProductEntity();
        BeanUtils.copyProperties(dto,object);
        return object;
    }

    public static ProductDto toDto(ProductEntity entity){
        var object = new ProductDto();
        BeanUtils.copyProperties(entity,object);
        return object;
    }

}
