package com.microservice.product.microserviceproduct.controller.product;
import com.microservice.product.microserviceproduct.config.controllerBase.ControllerBase;
import com.microservice.product.microserviceproduct.config.controllerBase.RequestEntities;
import com.microservice.product.microserviceproduct.dto.product.ProductDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("product")
public class ProductController implements ControllerBase<ProductDto, Integer> {

    @Override
    public ProductDto save(ProductDto obj) {
        return null;
    }

    @Override
    public ProductDto update(ProductDto obj, Integer integer) {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public ProductDto get(Integer integer) {
        return null;
    }

    @Override
    public List<ProductDto> getAll(RequestEntities obj) {
        return null;
    }
}
