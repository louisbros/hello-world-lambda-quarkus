package nz.brosnan.examples.lambdaquarkus.product;

import static org.mockito.BDDMockito.mock;
import static org.mockito.BDDMockito.then;
import static org.mockito.BDDMockito.times;

import nz.brosnan.examples.lambdaquarkus.product.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductControllerTest {
    private ProductService serviceMock;
    private ProductController controller;

    @BeforeEach
    public void setUp() {
        this.serviceMock = mock(ProductService.class);
        this.controller = new ProductController(this.serviceMock);
    }

    @Test
    public void testCreateCallsService() {
        // Given
        Product product = new Product();

        // When
        this.controller.create(product);

        // Then
        then(this.serviceMock).should(times(1)).create(product);
    }
}
