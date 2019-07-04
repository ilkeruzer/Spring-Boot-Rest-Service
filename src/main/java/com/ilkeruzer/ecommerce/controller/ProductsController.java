package com.ilkeruzer.ecommerce.controller;

import com.ilkeruzer.ecommerce.model.Products;
import com.ilkeruzer.ecommerce.model.Result;
import com.ilkeruzer.ecommerce.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductsController {
    @Autowired
    ProductsRepository productsRepository;

    @GetMapping("products/{id}")
    public Result getProducts(@PathVariable Integer id) {
        List<Products> productsList = productsRepository.findByCategoriesID(id);
        Result result = Result.createSuccessResult();
        result.addData("products",productsList);
        return result;
    }

    @GetMapping("/products-detail/{id}")
    public Result getProductDetail(@PathVariable Integer id) {
        Products product = productsRepository.findByProductID(id);
        Result result = Result.createSuccessResult();
        result.addData("product",product);
        return result;
    }
}
