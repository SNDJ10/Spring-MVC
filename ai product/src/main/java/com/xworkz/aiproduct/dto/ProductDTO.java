package com.xworkz.aiproduct.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Same as your ProductDTO
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
    private String description;
}
