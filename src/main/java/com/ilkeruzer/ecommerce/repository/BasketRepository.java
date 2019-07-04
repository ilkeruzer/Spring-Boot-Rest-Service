package com.ilkeruzer.ecommerce.repository;

import com.ilkeruzer.ecommerce.model.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface BasketRepository extends JpaRepository<Basket,Integer> {
    Basket findByProductID(Integer id);

    @Query(value = "SELECT SUM(products_price) FROM basket", nativeQuery = true)
    Float findByPriceSum();
    @Query(value = "SELECT SUM(products_piece) FROM basket", nativeQuery = true)
    Integer findBySumPiece();
}
