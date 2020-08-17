package nz.brosnan.examples.lambdaquarkus.product;

import static org.junit.jupiter.api.Assertions.assertEquals;

import nz.brosnan.examples.lambdaquarkus.product.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {
    private ProductRepository repository;

    @BeforeEach
    public void setUp() {
        this.repository = new ProductRepository();
    }

    @Test
    public void testCreate() {
        // Given
        Product product = new Product();

        // When
        Product createdProduct = this.repository.create(product);

        // Then
        assertEquals(product, createdProduct);
    }
}
