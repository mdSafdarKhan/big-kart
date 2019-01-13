package repository;

import com.example.productservice.model.Product;
import com.example.productservice.repository.ProductRepository;
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

    /*@Autowired
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
    }*/

}