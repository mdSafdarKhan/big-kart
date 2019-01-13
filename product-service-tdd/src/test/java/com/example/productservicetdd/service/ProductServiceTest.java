package com.example.productservicetdd.service;

import com.example.productservicetdd.model.Product;
import com.example.productservicetdd.model.ProductRequest;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class ProductServiceTest {

    //1. Expectation and then build - Fail and then pass
    //2. Expectation and then build (refactor for 1) - Fail and then pass
    //3. Expectation and then build (refactor for 1, 2)

    //SUT - System Under Test (Class Under Test)
    ProductService productService;

    @Before
    public void before(){
        productService = new ProductService();
    }

    @Test
    public void shouldSaveProduct(){

        //Given

        ProductRequest productRequest = ProductRequest.builder()
                .id(1L)
                .name("Iphone")
                .description("Smart phone")
                .quantity(10)
                .build();

        //When
        boolean saved = productService.save(productRequest);

        //Then
        Assertions.assertThat(saved).isTrue();
    }

    public class ProductService {
        public boolean save(ProductRequest productRequest) {
            return false;
        }
    }

}
