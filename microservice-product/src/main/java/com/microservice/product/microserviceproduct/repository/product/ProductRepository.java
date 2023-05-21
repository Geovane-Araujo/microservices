package com.microservice.product.microserviceproduct.repository.product;

import com.microservice.product.microserviceproduct.model.product.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
}
