package com.akvelon.server.service;

import com.akvelon.server.DAO.API.ProductDao;
import com.akvelon.server.entity.Product;
import com.akvelon.server.service.API.ProductService;
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
    public Integer addNewProduct(Product prod) {
        return productDao.addNewProduct(prod);
    }

    @Override
    public String deleteItem(String itemNumber) {
        return productDao.deleteItem(itemNumber);
    }
}