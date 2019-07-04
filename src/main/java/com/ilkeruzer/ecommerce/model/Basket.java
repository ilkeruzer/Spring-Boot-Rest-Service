package com.ilkeruzer.ecommerce.model;

import javax.persistence.*;

@Entity
public class Basket {

    @Id
    @Column(name = "products_id")
    private Integer productID;

    @Column(name = "products_price")
    private Float price;

    @Column(name = "products_piece")
    private Integer piece;

    public Basket() {}

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getPiece() {
        return piece;
    }

    public void setPiece(Integer piece) {
        this.piece = piece;
    }
}
