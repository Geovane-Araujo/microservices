package com.microservice.product.microserviceproduct.repository.supplier;

import com.microservice.product.microserviceproduct.model.supplier.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<SupplierEntity, Integer> {
}
