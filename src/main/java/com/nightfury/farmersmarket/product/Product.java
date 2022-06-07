package com.nightfury.farmersmarket.product;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "productSequence", sequenceName = "productSequence" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "productSequence")
    private Long productId;
    private String productName;
    private String productCategory;
    private Integer productPrice;
    private String productStock;
    private String productDescription;
    private String productLocation;
    private String productOwner;
    //private String productImageUrl;


    public Product() {}

    public Product(Long productId, String productName, String productCategory, Integer productPrice, String productStock, String productDescription, String productLocation, String productOwner) {
        this.productId = productId;
        this.productName = productName;
        this.productCategory = productCategory;
        this.productPrice = productPrice;
        this.productStock = productStock;
        this.productDescription = productDescription;
        this.productLocation = productLocation;
        this.productOwner = productOwner;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductStock() {
        return productStock;
    }

    public void setProductStock(String productStock) {
        this.productStock = productStock;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductLocation() {
        return productLocation;
    }

    public void setProductLocation(String productLocation) {
        this.productLocation = productLocation;
    }

    public String getProductOwner() {
        return productOwner;
    }

    public void setProductOwner(String productOwner) {
        this.productOwner = productOwner;
    }
}
