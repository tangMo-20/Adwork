package com.akvelon.server.controller;

import com.akvelon.server.entity.Product;
import com.akvelon.server.service.API.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class Controller {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/get_top_five")
    public List<Product> getTopFive() {
        return productService.getTopFive();
    }

    @RequestMapping(value = "/get_in_stock")
    public List<Product> getInStock() {
        return productService.getInStock();
    }

    @RequestMapping(value = "/search/{searchString}")
    public List<Product> searchProduct(@PathVariable String searchString) {
        return productService.searchProduct(searchString);
    }

    @RequestMapping(value = "/add_new")
    public Integer addNewProduct(@RequestBody Product prod) {
        return productService.addNewProduct(prod);
    }

    @RequestMapping(value = "/delete_item")
    public String deleteItem(@RequestBody String itemNumber) {
        return productService.deleteItem(itemNumber);
    }
}
