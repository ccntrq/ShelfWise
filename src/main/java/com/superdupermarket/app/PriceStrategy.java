package com.superdupermarket.app;

import java.time.LocalDate;

public interface PriceStrategy {
    int calculatePrice(Product product, LocalDate date);
}