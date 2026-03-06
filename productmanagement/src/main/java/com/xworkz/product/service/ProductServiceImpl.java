package com.xworkz.product.service;



import com.xworkz.product.dto.ProductDTO;
import com.xworkz.product.entity.ProductEntity;
import com.xworkz.product.repo.ProductDAO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO dao;

    @Override
    public String validateAndSave(ProductDTO dto) {

        if (dto.getProductName() != null &&
                dto.getPrice() != null && dto.getPrice() > 0 &&
                dto.getQuantity() != null && dto.getQuantity() > 0 &&
                dto.getSupplierEmail() != null &&
                dto.getSupplierEmail().contains("@")) {

            ProductEntity existing = dao.findByEmail(dto.getSupplierEmail());

            if (existing == null) {
                ProductEntity entity = new ProductEntity();
                BeanUtils.copyProperties(dto, entity);

                if (dao.saveProduct(entity)) {
                    return "Product Saved Successfully";
                }
                return "Product Save Failed";
            }
            return "Supplier Email Already Exists";
        }
        return "Invalid Product Data";
    }

    @Override
    public List<ProductDTO> getAllProducts() {

        List<ProductEntity> entities = dao.fetchAllProducts();
        List<ProductDTO> dtos = new ArrayList<>();

        entities.forEach(entity -> {
            ProductDTO dto = new ProductDTO();
            BeanUtils.copyProperties(entity, dto);
            dtos.add(dto);
        });

        return dtos;
    }

    @Override
    public ProductDTO getById(Integer id) {

        ProductEntity entity = dao.findById(id);

        if (entity != null) {
            ProductDTO dto = new ProductDTO();
            BeanUtils.copyProperties(entity, dto);
            return dto;
        }
        return null;
    }

    @Override
    public String updateProduct(ProductDTO dto) {

        ProductEntity entity = new ProductEntity();
        BeanUtils.copyProperties(dto, entity);

        if (dao.updateProduct(entity)) {
            return "Product Updated Successfully";
        }
        return "Update Failed";
    }

    @Override

    public String deleteProduct(Integer id) {

        if (id != null && id > 0) {

            boolean deleted = dao.deleteById(id);

            if (deleted) {
                return "Product Deleted Successfully";
            }
            return "Product Delete Failed";
        }

        return "Invalid Product ID";
    }
}