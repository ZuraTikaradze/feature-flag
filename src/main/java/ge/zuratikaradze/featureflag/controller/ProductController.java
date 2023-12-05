package ge.zuratikaradze.featureflag.controller;

import ge.zuratikaradze.featureflag.model.Product;
import ge.zuratikaradze.featureflag.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> products() {
        return productService.products();
    }

}
