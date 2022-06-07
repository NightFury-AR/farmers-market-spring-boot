package com.nightfury.farmersmarket.product;

import com.nightfury.farmersmarket.exception_handlers.APIExceptions.APIException;
import com.nightfury.farmersmarket.product.productvalidators.ProductFieldValidators;
import com.nightfury.farmersmarket.product.productvalidators.ProductValidationResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static com.nightfury.farmersmarket.product.productvalidators.ProductObjValidator.*;
import static com.nightfury.farmersmarket.product.productvalidators.ProductValidationResults.SUCCESS;

@RestController
@RequestMapping("farmers-market/api/v1/products/")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /*List<Product> productList = Arrays.asList(
            new Product(1L,"ooty carrot","vegetables",100,"1000","fresh ooty carrot available!","ooty,india","nightfury"),
            new Product(2L,"ooty chocolate","sweets",200,"1000","fresh ooty chocolates available!","ooty,india","nightfury"),
            new Product(3L,"coimbatore cauliflower","vegetables",100,"1000","fresh c-flower available!","ooty,india","nightfury"),
            new Product(4L,"coconut","drinks",100,"1000","fresh coconuts available!","pollachi,india","nightfury")
    );*/

    @GetMapping
    public List<Product> getProductList() {
        return productService.getProducts();
    }

    @GetMapping("{productId}")
    public Product getProductById(@PathVariable Long productId) {
        ProductValidationResults validationResult = ProductFieldValidators.isProductIdValid.apply(productId);
        if(!validationResult.equals(SUCCESS)) {
            throw new APIException(validationResult.name()+" : Given Product id is Not valid");
        }
        return productService.getProductById(productId);
    }

    @GetMapping("categories/{productCategory}")
    public List<Product> getProductsByCategories(@PathVariable String productCategory) {
        ProductValidationResults isValid = ProductFieldValidators.isProductCategoryValid.apply(productCategory);
        if(!isValid.equals(SUCCESS)) {
            throw new APIException(isValid.name()+" : Given Product category is not valid");
        }
        return productService.getProductsByCategory(productCategory);
    }

    @PostMapping
    public Product addNewProduct(@RequestBody Product newProduct) {
        ProductValidationResults isValid = checkProductId()
                .and(checkProductName())
                .and(checkProductCategory())
                .and(checkProductDescription())
                .and(checkProductLocation())
                .and(checkProductPrice())
                .and(checkProductStock())
                .and(checkProductOwner())
                .apply(newProduct);
        if(!isValid.equals(SUCCESS)) {
            throw new APIException(isValid.name()+" : please check add again");
        }
        return productService.addNewProduct(newProduct);
    }

    @DeleteMapping("remove/{productId}")
    public void removeProductById(@PathVariable Long productId) {
        ProductValidationResults isValid = ProductFieldValidators.isProductIdValid.apply(productId);
        if(!isValid.equals(SUCCESS)) {
            throw new APIException(isValid.name()+" : Given Product id is Not valid");
        }
        productService.removeProduct(productId);
    }


}
