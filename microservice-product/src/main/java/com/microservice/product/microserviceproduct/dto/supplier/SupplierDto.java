package com.microservice.product.microserviceproduct.dto.supplier;

import com.microservice.product.microserviceproduct.dto.category.CategoryDto;
import com.microservice.product.microserviceproduct.dto.product.ProductDto;
import com.microservice.product.microserviceproduct.model.category.CategoryEntity;
import com.microservice.product.microserviceproduct.model.product.ProductEntity;
import com.microservice.product.microserviceproduct.model.supplier.SupplierEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.BeanUtils;


@Data
public class SupplierDto {

    public Integer id;
    public String name;

    public static SupplierEntity toEntity(SupplierDto dto){
        var object = new SupplierEntity();
        BeanUtils.copyProperties(dto,object);
        return object;
    }

    public static SupplierDto toDto(SupplierEntity entity){
        var object = new SupplierDto();
        BeanUtils.copyProperties(entity,object);
        return object;
    }

}
