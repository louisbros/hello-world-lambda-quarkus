package nz.brosnan.examples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import nz.brosnan.examples.product.ProductController;
import nz.brosnan.examples.product.ProductService;

@SpringBootApplication
@Import({ ProductController.class, ProductService.class })
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
