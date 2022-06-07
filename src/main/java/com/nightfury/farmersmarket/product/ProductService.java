package com.nightfury.farmersmarket.product;

import com.nightfury.farmersmarket.exception_handlers.ServiceExceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //adding new productvalidators
    public Product addNewProduct(Product product) {
        return productRepository.save(product);
    }

    //get all productvalidators
    public List<Product> getProducts() {
        List<Product> productList = productRepository.findAll();
        if(productList.isEmpty()) throw new ServiceException("Product is Empty", HttpStatus.NO_CONTENT);
        return productList;
    }

    //get productvalidators by its id
    public Product getProductById(Long productId) {
        Optional<Product> product = productRepository.findById(productId);
        product.orElseThrow( () -> new ServiceException("Given Id "+productId+" is not found !",HttpStatus.NOT_FOUND));
        return product.get();
    }

    public List<Product> getProductsByCategory(String category) {
        List<Product> productListByCategory= productRepository.findByProductCategory(category);
        if(productListByCategory.isEmpty()) throw new ServiceException("There is no product available for given category !",HttpStatus.NO_CONTENT);
        return productListByCategory;
    }

    //update productvalidators
    public Product updateProductDetails(Long productId,Product newData) {
        Optional<Product> existingProduct = productRepository.findById(productId);
        existingProduct.orElseThrow(() -> new ServiceException("given id is not exist",HttpStatus.NOT_FOUND));
        Product updatedProduct = existingProduct.get();
        updatedProduct = newData;
        return updatedProduct;
    }

    //delete productvalidators
    public void removeProduct(Long productId) {
        boolean b = productRepository.existsById(productId);
        if(!b) throw new ServiceException("Given product id "+productId+ " does not exist in database !",HttpStatus.NOT_FOUND);
        productRepository.deleteById(productId);
    }



}
