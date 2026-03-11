package com.xworkz.aiproduct.repo;

import com.xworkz.aiproduct.entity.ProductEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// Same as your ProductDAOImpl
@Repository
@Transactional
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public boolean saveProduct(ProductEntity entity) {
        try {
            getSession().save(entity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<ProductEntity> fetchAllProducts() {
        return getSession()
                .createNamedQuery("fetchAllProducts", ProductEntity.class)
                .getResultList();
    }

    @Override
    public ProductEntity findById(Integer id) {
        return getSession().get(ProductEntity.class, id);
    }

    @Override
    public ProductEntity findByEmail(String email) {
        try {
            return getSession()
                    .createNamedQuery("findByEmail", ProductEntity.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean updateProduct(ProductEntity entity) {
        try {
            getSession().merge(entity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteById(Integer id) {
        try {
            ProductEntity entity = findById(id);
            if (entity != null) {
                getSession().delete(entity);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
