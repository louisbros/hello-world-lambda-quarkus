package nz.brosnan.examples.lambdaquarkus.product;

import javax.enterprise.context.ApplicationScoped;
import nz.brosnan.examples.lambdaquarkus.product.model.Product;

@ApplicationScoped
public class ProductRepository {
    public Product create(Product product) {
        return product;
    }
}
