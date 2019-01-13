package com.example.productservice.service;

import com.example.productservice.model.Product;
import com.example.productservice.model.ProductRequest;
import com.example.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product save(ProductRequest productRequest) {

        Product productToBeSaved = TransformProduct(productRequest);
        //lots of business
        //Transform the DTO to DAO
        //Convert this request entity to product entity
        //Is the model complete and correct
        //Talk to some other service to get some other attributes of product
        //Filter some of the details from product
        return productRepository.save(productToBeSaved);
    }

    public Boolean isProductExists(Long id) {
        Optional<Product> prod = productRepository.findProductById(id);
        return prod.isPresent();
    }

    public static Product TransformProduct(ProductRequest productRequest) {
        return Product.builder()
                .id(productRequest.getId())
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .quantity(productRequest.getQuantity())
                .build();
    }
}
