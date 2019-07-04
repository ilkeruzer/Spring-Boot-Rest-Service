package com.ilkeruzer.ecommerce.repository;

import com.ilkeruzer.ecommerce.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Products,Integer> {

    List<Products> findByCategoriesID(Integer id);

    Products findByProductID(Integer id);

    List<Products> findByProductIDIn(List<Integer> integerList);

}
