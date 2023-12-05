package ge.zuratikaradze.featureflag.service;

import ge.zuratikaradze.featureflag.model.Product;
import org.springframework.stereotype.Service;
import org.togglz.core.Feature;

import org.togglz.core.manager.FeatureManager;
import org.togglz.core.util.NamedFeature;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {


    private final FeatureManager featureManager;


    public static final Feature DISCOUNT_APPLIED = new NamedFeature("DISCOUNT_APPLIED");

    public ProductService(FeatureManager featureManager) {
        this.featureManager = featureManager;
    }

    public List<Product> products() {
        List<Product> products = Arrays.asList(
                new Product(1L, "Iphone 11", new BigDecimal(100)),
                new Product(1L, "Iphone 12", new BigDecimal(200)),
                new Product(1L, "Iphone 13", new BigDecimal(300))
        );
        if (featureManager.isActive(DISCOUNT_APPLIED)) {
            return discount(products);
        } else {
            return products;
        }
    }

    public List<Product> discount(List<Product> products) {
        return products.stream().map(product -> {
            BigDecimal originalPrice = product.getPrice();
            BigDecimal discountAmount = originalPrice.multiply(BigDecimal.valueOf(0.10)); // 10% discount
            BigDecimal discountedPrice = originalPrice.subtract(discountAmount);
            return new Product(product.getId(), product.getName(), discountedPrice);
        }).collect(Collectors.toList());
    }
}
