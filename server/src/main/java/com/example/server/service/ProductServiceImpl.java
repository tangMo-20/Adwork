package com.example.server.service;

import com.example.server.DAO.API.ProductDao;
import com.example.server.entity.Product;
import com.example.server.service.API.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private static ProductServiceImpl productService;
    @Autowired
    private ProductDao productDao;

    protected ProductServiceImpl() {
        if (productService == null) {
            productService = this;
        }
    }

    public static synchronized ProductServiceImpl getInstance() {
        if (productService == null) {
            productService = new ProductServiceImpl();
        }
        return productService;
    }

    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Override
    public List<Product> getInStock() {
        return productDao.getInStock();
    }

    @Override
    public List<Product> getTopFive() {
        return productDao.getTopFive();
    }

    @Override
    public List<Product> searchProduct(String searchRequest) {
        return productDao.searchProduct(searchRequest);
    }

    @Override
    public Integer create(Product value) {
        return productDao.create(value);
    }

    @Override
    public Product read(Integer key) {
        return productDao.read(key);
    }

//    //@Override
//    public Product read(String key) {
//        return productDao.read(key);
//    }

//    @Override
//    public void update(Product value) {
//        productDao.update(value);
//    }
//
//    @Override
//    public void delete(String key) {
//        productDao.delete(key);
//    }

    @Override
    public <T> Product readBy(String fieldName, T value) {
        return productDao.readBy(fieldName, value);
    }

    @Override
    public <T> List<Product> readAllBy(String fieldName, T value) {
        return productDao.readAllBy(fieldName, value);
    }
}