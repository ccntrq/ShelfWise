package com.superdupermarket.app;

import java.time.LocalDate;

public class ProductFactory {

    public enum ProductType {
        CHEESE, WINE
    }

    public static Product createProduct(
            ProductType productType,
            String label,
            LocalDate shelfDate,
            int basePrice,
            int baseQuality,
            LocalDate expirationDate) {
        Product product;

        switch (productType) {
            case CHEESE:
                product = new Cheese(label, shelfDate, basePrice, baseQuality, expirationDate);
                break;
            case WINE:
                product = new Wine(label, shelfDate, basePrice, baseQuality);
                break;
            default:
                throw new IllegalArgumentException("Invalid product type: " + productType);
        }

        return product;
    }
}