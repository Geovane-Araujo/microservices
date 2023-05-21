package com.microservice.product.microserviceproduct.model.supplier;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="supplier")
public class SupplierEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;


}
