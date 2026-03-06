package com.xworkz.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Integer id;
    private String productName;
    private String category;
    private Double price;
    private Integer quantity;
    private String supplierEmail;
}
