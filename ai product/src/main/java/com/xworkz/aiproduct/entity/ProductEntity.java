package com.xworkz.aiproduct.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// Same structure as your ProductEntity
@Entity
@Table(name = "ai_product_tb")
@NamedQuery(name = "fetchAllProducts", query = "select p from ProductEntity p")
@NamedQuery(name = "findByEmail",      query = "select p from ProductEntity p where p.supplierEmail = :email")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String productName;
    private String category;
    private Double price;
    private Integer quantity;
    private String supplierEmail;
    private String description; // NEW: product description field
}
