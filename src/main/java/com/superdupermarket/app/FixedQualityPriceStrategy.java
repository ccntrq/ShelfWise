package com.superdupermarket.app;

import java.time.LocalDate;

// Ignores quality changes over time - Only the baseQuality of a product is
// considered for the price calculation
public class FixedQualityPriceStrategy implements PriceStrategy {
    @Override
    public int calculatePrice(Product product, LocalDate checkDate) {
        return product.basePrice + product.baseQuality * 10;
    }
}
