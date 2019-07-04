package com.ilkeruzer.ecommerce.controller;

import com.ilkeruzer.ecommerce.model.Basket;
import com.ilkeruzer.ecommerce.model.Products;
import com.ilkeruzer.ecommerce.model.Result;
import com.ilkeruzer.ecommerce.repository.BasketRepository;
import com.ilkeruzer.ecommerce.repository.ProductsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class BasketController {

    @Autowired
    BasketRepository basketRepository;

    @Autowired
    ProductsRepository productsRepository;

    @PostMapping("/add-basket")
    public Result addBasket(@RequestBody Basket customer) {
        Result result;
        if (basketRepository.findByProductID(customer.getProductID()) == null) {
            System.out.println("Basket : eklendi" );
            customer.setPiece(1);
            basketRepository.save(customer);
            result = Result.createSuccessResult("Ürün başarıyla sepetinize eklenmiştir.");

        } else {
            System.out.println("Basket : boş" );
            Basket basket = basketRepository.findByProductID(customer.getProductID());
            float price = basket.getPrice() + customer.getPrice();
            customer.setPrice(price);
            customer.setPiece(basket.getPiece()+1);
            basketRepository.save(customer);
            result = Result.createSuccessResult("Sepetinizdeki ürün güncellenmiştir.");
        }
        return result;
    }

    @GetMapping("/basket")
    public Result getAllBasket() {
        List<Basket> basketList = basketRepository.findAll();
        List<Integer> idList = new ArrayList<>();
        for (int i=0; i<basketList.size(); i++) {
            idList.add(basketList.get(i).getProductID());
        }

        List<Products> productsList = productsRepository.findByProductIDIn(idList);
        Result result = Result.createSuccessResult();
        result.addData("total",basketRepository.findByPriceSum());
        result.addData("basket",productsList);
        return result;
    }

    @GetMapping("/delete-basket")
    public Result deleteBasket() {
        basketRepository.deleteAll();
        Result result = Result.createSuccessResult("Alışveriş başarılı bir şekilde gerçekleştirildi.");
        return result;
    }

    @GetMapping("/count-basket")
    public Result countBasket() {
        Result result = Result.createSuccessResult();
        result.addData("total_piece",basketRepository.findBySumPiece());
        return result;
    }
}
