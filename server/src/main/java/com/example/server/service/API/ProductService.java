package com.example.server.service.API;

import com.example.server.entity.Product;

import java.util.List;

public interface ProductService extends Service<Integer, Product> {
    public List<Product> getInStock();

    public List<Product> getTopFive();

    public List<Product> searchProduct(String searchRequest);
}