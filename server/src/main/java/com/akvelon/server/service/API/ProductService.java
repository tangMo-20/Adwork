package com.akvelon.server.service.API;

import com.akvelon.server.entity.Product;
import java.util.List;

public interface ProductService extends Service<Integer, Product> {

    public List<Product> getInStock();

    public List<Product> getTopFive();

    public List<Product> searchProduct(String searchRequest);
}