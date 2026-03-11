package com.xworkz.aiproduct.repo;

import com.xworkz.aiproduct.entity.ProductEntity;
import java.util.List;

// Same as your ProductDAO interface
public interface ProductDAO {
    boolean saveProduct(ProductEntity entity);
    List<ProductEntity> fetchAllProducts();
    ProductEntity findById(Integer id);
    ProductEntity findByEmail(String email);
    boolean updateProduct(ProductEntity entity);
    boolean deleteById(Integer id);
}
