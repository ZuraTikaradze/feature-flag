package ge.zuratikaradze.featureflag.service;

import ge.zuratikaradze.featureflag.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.togglz.core.manager.FeatureManager;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private FeatureManager featureManager;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testProductsNoDiscount() {
        when(featureManager.isActive(ProductService.DISCOUNT_APPLIED)).thenReturn(false);
        List<Product> products = productService.products();
        assertEquals(3, products.size());
        assertEquals(new BigDecimal(100), products.get(0).getPrice());
        assertEquals(new BigDecimal(200), products.get(1).getPrice());
        assertEquals(new BigDecimal(300), products.get(2).getPrice());
        verify(featureManager).isActive(ProductService.DISCOUNT_APPLIED);
    }

    @Test
    public void testProductsWithDiscount() {
        when(featureManager.isActive(ProductService.DISCOUNT_APPLIED)).thenReturn(true);
        List<Product> products = productService.products();
        assertEquals(3, products.size());
        assertEquals(new BigDecimal("90.0"), products.get(0).getPrice());
        assertEquals(new BigDecimal("180.0"), products.get(1).getPrice());
        assertEquals(new BigDecimal("270.0"), products.get(2).getPrice());
        verify(featureManager).isActive(ProductService.DISCOUNT_APPLIED);
    }

    @Test
    public void testDiscountMethod() {
        List<Product> products = Arrays.asList(
                new Product(1L, "TestProduct1", new BigDecimal(100)),
                new Product(2L, "TestProduct2", new BigDecimal(200))
        );
        List<Product> discountedProducts = productService.discount(products);
        assertEquals(new BigDecimal("90.0"), discountedProducts.get(0).getPrice());
        assertEquals(new BigDecimal("180.0"), discountedProducts.get(1).getPrice());
    }
}
