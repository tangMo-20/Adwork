package com.akvelon.server.DAO.API;

import com.akvelon.server.entity.Product;

import java.util.List;

public interface ProductDao extends dao<Integer, Product> {
    public List<Product> getInStock();

    public List<Product> getTopFive();

    public List<Product> searchProduct(String searchRequest);
}