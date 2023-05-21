package com.microservice.product.microserviceproduct.repository.category;

import com.microservice.product.microserviceproduct.model.category.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
}
