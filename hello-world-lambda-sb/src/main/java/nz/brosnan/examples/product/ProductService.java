package nz.brosnan.examples.product;

import nz.brosnan.examples.product.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductService {

    public Product create(Product product) {
        return product;
    }
}
