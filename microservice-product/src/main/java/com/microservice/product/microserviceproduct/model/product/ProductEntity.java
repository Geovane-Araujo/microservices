package com.microservice.product.microserviceproduct.model.product;

import com.microservice.product.microserviceproduct.model.category.CategoryEntity;
import com.microservice.product.microserviceproduct.model.supplier.SupplierEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    private CategoryEntity category;

    @ManyToOne(fetch = FetchType.LAZY)
    private SupplierEntity supplier;

}
