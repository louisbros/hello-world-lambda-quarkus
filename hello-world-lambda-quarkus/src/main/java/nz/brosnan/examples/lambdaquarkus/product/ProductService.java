package nz.brosnan.examples.lambdaquarkus.product;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import nz.brosnan.examples.lambdaquarkus.product.model.Product;

@ApplicationScoped
public class ProductService {
    private ProductRepository repository;

    @Inject
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product create(Product product) {
        return this.repository.create(product);
    }
}
