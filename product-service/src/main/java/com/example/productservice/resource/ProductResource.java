package com.example.productservice.resource;

import com.example.productservice.model.Product;
import com.example.productservice.model.ProductRequest;
import com.example.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "product")
public class ProductResource {

    @Autowired
    ProductService productService;

    @PostMapping
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveProduct(@RequestBody ProductRequest productRequest) {
        Product savedProduct = productService.save(productRequest);
        if (savedProduct != null) {
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            throw new ProductNotCreatedException();
        }
    }

    public static class ProductNotCreatedException extends RuntimeException {

    }

    @GetMapping
    public ResponseEntity isProductInInventory(Long id) {
        Boolean productExists = productService.isProductExists(id);
        return ResponseEntity.status(HttpStatus.OK).body(productExists);
    }
}
