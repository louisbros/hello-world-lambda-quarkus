package nz.brosnan.examples.lambdaquarkus.product;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import nz.brosnan.examples.lambdaquarkus.product.model.Product;

@Path("/product")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductController {
    private ProductService service;

    @Inject
    public ProductController(ProductService service) {
        this.service = service;
    }

    @POST
    public Product create(Product product) {
        return this.service.create(product);
    }
}
