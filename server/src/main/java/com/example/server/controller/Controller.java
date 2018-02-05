package com.example.server.controller;

import com.example.server.entity.Product;
import com.example.server.service.API.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class Controller {
    @Autowired
    private ProductService productService;
    private String req;

    @RequestMapping(value = "/")
    public String index() {
        return "index.html";
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/get_all")
    public List<Product> getAll() {
        return productService.getAll();
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/get_in_stock")
    public List<Product> getInStock() {
        return productService.getInStock();
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/search/{searchString}")
    public List<Product> searchProduct(@PathVariable String searchString) {
        return productService.searchProduct(searchString);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/get_top_five")
    public List<Product> getTopFive() {
        return productService.getTopFive();
    }
}
