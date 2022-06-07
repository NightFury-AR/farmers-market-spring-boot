package com.nightfury.farmersmarket.product.productvalidators;

import java.util.function.Function;
import static com.nightfury.farmersmarket.product.productvalidators.ProductValidationResults.*;

public interface ProductFieldValidators {

    // not null & greater than 0
    static Function<Long, ProductValidationResults> isProductIdValid = productId -> productId!=null && productId>0 ? SUCCESS : INVALID_PRODUCT_ID;
    // not null & contains 3 or more letters
    static Function<String,ProductValidationResults> isProductNameValid = productName -> productName!=null && productName.trim().length()>=3 ? SUCCESS : INVALID_PRODUCT_NAME;
    // not null & contains 3 or more letters
    static Function<String,ProductValidationResults> isProductCategoryValid = productCategory -> productCategory!=null && productCategory.trim().length()>=3 ? SUCCESS : INVALID_PRODUCT_CATEGORY;
    // not null & greater than 0
    static Function<Integer,ProductValidationResults> isProductPriceValid = productPrice -> productPrice!=null && productPrice>0 ? SUCCESS : INVALID_PRODUCT_PRICE;
    // not null & contains 2 or more letters
    static Function<String,ProductValidationResults> isProductStockValid = productStock -> productStock!=null && productStock.trim().length() > 1 ? SUCCESS : INVALID_PRODUCT_STOCK;
    // not null & contains 150 or less letters
    static Function<String,ProductValidationResults> isProductDescriptionValid = productDescription -> productDescription!=null && productDescription.trim().length() <=150 ? SUCCESS : INVALID_PRODUCT_DESCRIPTION;
    // not null & contains 2 or more letters
    static Function<String,ProductValidationResults> isProductLocationValid = productLocation -> productLocation!=null && productLocation.trim().length() > 2 ? SUCCESS : INVALID_PRODUCT_LOCATION;
    // not null & contains 3 or more letters
    static Function<String,ProductValidationResults> isProductOwnerValid = productOwner -> productOwner!=null && productOwner.trim().length() >= 3 ? SUCCESS : INVALID_PRODUCT_OWNER;



}
