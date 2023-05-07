package com.superdupermarket.app;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class StaticProductRepository implements ProductRepository {

    @Override
    public List<Product> fetchProducts() {
        LocalDate today = LocalDate.now();

        Product[] products = {
                ProductFactory.createProduct(ProductType.CHEESE, "Cheddar", today, 399, 50, today.plusDays(10)),
                ProductFactory.createProduct(ProductType.CHEESE, "Parmigiano", today, 475, 50, today.plusDays(55)),
                ProductFactory.createProduct(ProductType.WINE, "Riesling", today, 1099, 25, null),
                ProductFactory.createProduct(ProductType.FRESH_PRODUCE, "Onion", today, 199, 10, today.plusDays(10)),
                ProductFactory.createProduct(ProductType.FRESH_PRODUCE, "Banana", today, 199, -10, today.plusDays(10)),
        };

        return Arrays.asList(products);
    }
}
