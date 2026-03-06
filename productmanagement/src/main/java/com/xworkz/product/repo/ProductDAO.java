package com.xworkz.product.repo;



import com.xworkz.product.entity.ProductEntity;
import java.util.List;

public interface ProductDAO {

    boolean saveProduct(ProductEntity entity);

    ProductEntity findByEmail(String email);

    List<ProductEntity> fetchAllProducts();

    ProductEntity findById(Integer id);

    boolean updateProduct(ProductEntity entity);
    boolean deleteById(Integer id);
}
