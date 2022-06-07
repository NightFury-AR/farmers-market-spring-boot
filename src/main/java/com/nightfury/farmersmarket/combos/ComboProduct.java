package com.nightfury.farmersmarket.combos;

import java.util.List;

public class ComboProduct {

    private Long comboProductId;
    private String comboProductName;
    private String comboProductCategory;
    private List<String> comboProductItems;
    private Integer comboProductPrice;
    private String comboProductStock;
    private String comboProductDescription;
    private String comboProductLocation;
    private String comboProductOwner;

    public ComboProduct(Long comboProductId, String comboProductName, String comboProductCategory, List<String> comboProductItems, Integer comboProductPrice, String comboProductStock, String comboProductDescription, String comboProductLocation, String comboProductOwner) {
        this.comboProductId = comboProductId;
        this.comboProductName = comboProductName;
        this.comboProductCategory = comboProductCategory;
        this.comboProductItems = comboProductItems;
        this.comboProductPrice = comboProductPrice;
        this.comboProductStock = comboProductStock;
        this.comboProductDescription = comboProductDescription;
        this.comboProductLocation = comboProductLocation;
        this.comboProductOwner = comboProductOwner;
    }

    public Long getComboProductId() {
        return comboProductId;
    }

    public void setComboProductId(Long comboProductId) {
        this.comboProductId = comboProductId;
    }

    public String getComboProductName() {
        return comboProductName;
    }

    public void setComboProductName(String comboProductName) {
        this.comboProductName = comboProductName;
    }

    public String getComboProductCategory() {
        return comboProductCategory;
    }

    public void setComboProductCategory(String comboProductCategory) {
        this.comboProductCategory = comboProductCategory;
    }

    public List<String> getComboProductItems() {
        return comboProductItems;
    }

    public void setComboProductItems(List<String> comboProductItems) {
        this.comboProductItems = comboProductItems;
    }

    public Integer getComboProductPrice() {
        return comboProductPrice;
    }

    public void setComboProductPrice(Integer comboProductPrice) {
        this.comboProductPrice = comboProductPrice;
    }

    public String getComboProductStock() {
        return comboProductStock;
    }

    public void setComboProductStock(String comboProductStock) {
        this.comboProductStock = comboProductStock;
    }

    public String getComboProductDescription() {
        return comboProductDescription;
    }

    public void setComboProductDescription(String comboProductDescription) {
        this.comboProductDescription = comboProductDescription;
    }

    public String getComboProductLocation() {
        return comboProductLocation;
    }

    public void setComboProductLocation(String comboProductLocation) {
        this.comboProductLocation = comboProductLocation;
    }

    public String getComboProductOwner() {
        return comboProductOwner;
    }

    public void setComboProductOwner(String comboProductOwner) {
        this.comboProductOwner = comboProductOwner;
    }
}
