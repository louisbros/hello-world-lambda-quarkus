package nz.brosnan.examples.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import nz.brosnan.examples.product.model.Product;

@RestController
@EnableWebMvc
public class ProductController {
    private ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @RequestMapping(path = "/product", method = RequestMethod.POST)
    public Product create(@RequestBody Product product) {
        return this.service.create(product);
    }
}
