package com.xworkz.aiproduct.service;

import com.xworkz.aiproduct.dto.ProductDTO;
import com.xworkz.aiproduct.entity.ProductEntity;
import com.xworkz.aiproduct.repo.ProductDAO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// Same pattern as your ProductServiceImpl
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO dao;

    @Override
    public String validateAndSave(ProductDTO dto) {
        if (dto.getProductName() != null && !dto.getProductName().isEmpty() &&
                dto.getPrice() != null && dto.getPrice() > 0 &&
                dto.getQuantity() != null && dto.getQuantity() > 0 &&
                dto.getSupplierEmail() != null && dto.getSupplierEmail().contains("@")) {

            ProductEntity existing = dao.findByEmail(dto.getSupplierEmail());
            if (existing == null) {
                ProductEntity entity = new ProductEntity();
                BeanUtils.copyProperties(dto, entity);
                if (dao.saveProduct(entity)) {
                    return "Product Saved Successfully!";
                }
                return "Product Save Failed";
            }
            return "Supplier Email Already Exists";
        }
        return "Invalid Product Data - Please fill all fields correctly";
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
            return "Product Updated Successfully!";
        }
        return "Update Failed";
    }

    @Override
    public String deleteProduct(Integer id) {
        if (id != null && id > 0) {
            if (dao.deleteById(id)) {
                return "Product Deleted Successfully!";
            }
            return "Delete Failed";
        }
        return "Invalid Product ID";
    }
}
