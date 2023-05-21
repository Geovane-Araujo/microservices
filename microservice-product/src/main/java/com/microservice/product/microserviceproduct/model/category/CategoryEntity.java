package com.microservice.product.microserviceproduct.model.category;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name="category")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String description;
}
