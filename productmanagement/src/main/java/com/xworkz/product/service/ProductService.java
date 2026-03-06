package com.xworkz.product.service;



import com.xworkz.product.dto.ProductDTO;
import java.util.List;

public interface ProductService {

    String validateAndSave(ProductDTO dto);

    List<ProductDTO> getAllProducts();

    ProductDTO getById(Integer id);

    String updateProduct(ProductDTO dto);

    String deleteProduct(Integer id);
}
