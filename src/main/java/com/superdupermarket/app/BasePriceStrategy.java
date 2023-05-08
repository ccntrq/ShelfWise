package com.superdupermarket.app;

import java.time.LocalDate;

public class BasePriceStrategy implements PriceStrategy {
    @Override
    public int calculatePrice(Product product, LocalDate checkDate) {
        // The day price is the basePrice plus an additional 10 cents for each
        // point of quality
        return product.basePrice + product.quality(checkDate) * 10;
    }
}
