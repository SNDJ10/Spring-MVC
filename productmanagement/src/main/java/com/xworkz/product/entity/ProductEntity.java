package com.xworkz.product.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "product_tb")
@NamedQuery(name = "deleteData", query = "delete from ProductEntity p where p.id = :id")
@NamedQuery(name = "findByEmail", query = "select p from ProductEntity p where p.supplierEmail=:email")
@NamedQuery(name = "fetchAllProducts", query = "select p from ProductEntity p")
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
}