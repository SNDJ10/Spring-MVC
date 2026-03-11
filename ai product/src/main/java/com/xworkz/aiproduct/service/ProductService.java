package com.xworkz.aiproduct.service;

import com.xworkz.aiproduct.dto.ProductDTO;
import java.util.List;

public interface ProductService {
    String validateAndSave(ProductDTO dto);
    List<ProductDTO> getAllProducts();
    ProductDTO getById(Integer id);
    String updateProduct(ProductDTO dto);
    String deleteProduct(Integer id);
}
