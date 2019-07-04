package com.ilkeruzer.ecommerce.model;

import javax.persistence.*;

@Entity
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "products_id")
    private Integer productID;

    @Column(name = "categories_id")
    private Integer categoriesID;

    @Column(name = "products_name")
    private String name;

    @Column(name = "products_price")
    private Float price;

    @Column(name = "products_image")
    private String image;

    @Column(name = "products_detail")
    private String detail;

    public Products() {}

    public Integer getProductID() {
        return productID;
    }

    public String getName() {
        return name;
    }

    public Float getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public String getDetail() {
        return detail;
    }
}
