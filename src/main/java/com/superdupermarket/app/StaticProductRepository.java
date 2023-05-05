package com.superdupermarket.app;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.superdupermarket.app.ProductFactory.ProductType;

public class StaticProductRepository implements ProductRepository {

    @Override
    public List<Product> fetchProducts() {
        LocalDate today = LocalDate.now();

        Product[] products = {
                ProductFactory.createProduct(ProductType.CHEESE, "Cheddar", today, 399, 50, today.plusDays(10)),
                ProductFactory.createProduct(ProductType.CHEESE, "Parmigiano", today, 475, 50, today.plusDays(55)),
                ProductFactory.createProduct(ProductType.WINE, "Riesling", today, 1099, 25, null),
        };

        return Arrays.asList(products);
    }
}
