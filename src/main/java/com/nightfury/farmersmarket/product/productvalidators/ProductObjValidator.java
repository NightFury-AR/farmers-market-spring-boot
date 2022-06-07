package com.nightfury.farmersmarket.product.productvalidators;

import com.nightfury.farmersmarket.product.Product;

import java.util.function.Function;

public interface ProductObjValidator extends Function<Product, ProductValidationResults> {


    // not null and greater than 0
    static ProductObjValidator checkProductId() {
        return product -> {
            return ProductFieldValidators.isProductIdValid.apply(product.getProductId());
        };
    }

    // not null & greater than 3 chars
    static ProductObjValidator checkProductName() {
        return product -> {
            return ProductFieldValidators.isProductNameValid.apply(product.getProductName());
        };
    }

    // not null & greater than 3 letters
    static ProductObjValidator checkProductCategory() {
        return product -> {
            return ProductFieldValidators.isProductCategoryValid.apply(product.getProductCategory());
        };
    }

    // not null & greater than 0
    static ProductObjValidator checkProductPrice() {
        return product -> {
            return ProductFieldValidators.isProductPriceValid.apply(product.getProductPrice());
        };
    }

    // not null & greater than 3 letters
    static ProductObjValidator checkProductStock() {
        return product -> {
            return ProductFieldValidators.isProductStockValid.apply(product.getProductStock());
        };
    }

    // not null & less than or equals to 150 letters
    static ProductObjValidator checkProductDescription() {
        return product -> {
            return ProductFieldValidators.isProductDescriptionValid.apply(product.getProductDescription());
        };
    }

    // not null & greater than 3 letters
    static ProductObjValidator checkProductLocation() {
        return product -> {
            return ProductFieldValidators.isProductLocationValid.apply(product.getProductLocation());
        };
    }

    static ProductObjValidator checkProductOwner() {
        return product -> {
            return ProductFieldValidators.isProductOwnerValid.apply(product.getProductOwner());
        };
    }

    default ProductObjValidator and (ProductObjValidator other) {
        return product -> {
            ProductValidationResults validationResult = this.apply(product);
            return validationResult.equals(ProductValidationResults.SUCCESS) ? other.apply(product) : validationResult;
        };
    }


}
