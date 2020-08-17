package nz.brosnan.examples.lambdaquarkus.product;

import static org.mockito.BDDMockito.mock;
import static org.mockito.BDDMockito.then;
import static org.mockito.BDDMockito.times;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import nz.brosnan.examples.lambdaquarkus.product.model.Product;

public class ProductServiceTest {
    private ProductRepository repositoryMock;
    private ProductService service;

    @BeforeEach
    public void setUp() {
        this.repositoryMock = mock(ProductRepository.class);
        this.service = new ProductService(this.repositoryMock);
    }

    @Test
    public void testCreateCallsRepository() {
        // Given
        Product product = new Product();

        // When
        this.service.create(product);

        // Then
        then(this.repositoryMock).should(times(1)).create(product);
    }
}
