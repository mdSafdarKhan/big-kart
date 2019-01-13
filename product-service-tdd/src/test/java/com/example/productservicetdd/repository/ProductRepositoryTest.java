package com.example.productservicetdd.repository;

import com.example.productservicetdd.model.Product;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
//@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    public void testSaveOfProduct() {
        System.out.println("Inside testSaveOfProduct");
        Product product = Product.builder()
                .id(1L)
                .name("Iphone")
                .description("Smart phone")
                .quantity(10)
                .build();

        productRepository.save(product);

        Optional<Product> optionalProduct = productRepository.findById(11);

        Assertions.assertThat(optionalProduct.isPresent()).isTrue();
        Assertions.assertThat(product).isEqualTo(optionalProduct.get());
    }

    @Test
    public void testDeleteOfProduct(){
        Product product = Product.builder()
                .id(1L)
                .name("Phone1")
                .description("Smart phone")
                .quantity(11)
                .build();

        productRepository.save(product);
        productRepository.delete(product);
        Optional<Product> productFoundInDB = productRepository.findById(1);
        Assertions.assertThat(productFoundInDB.isPresent()).isFalse();
    }

}