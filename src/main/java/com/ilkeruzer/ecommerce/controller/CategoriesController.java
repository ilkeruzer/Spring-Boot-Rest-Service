package com.ilkeruzer.ecommerce.controller;

import com.ilkeruzer.ecommerce.model.Categories;
import com.ilkeruzer.ecommerce.repository.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.ilkeruzer.ecommerce.model.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CategoriesController {

    @Autowired
    CategoriesRepository categoriesRepository;

    @GetMapping("/categories")
    public ResponseEntity<Result> getCategories(){
       Iterable<Categories> allCategories = categoriesRepository.findAll();
       Result result = Result.createSuccessResult();
       result.addData("categories",allCategories);
       return ResponseEntity.ok().body(result);
    }
}
