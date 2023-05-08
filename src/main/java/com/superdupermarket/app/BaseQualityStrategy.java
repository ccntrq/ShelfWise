package com.superdupermarket.app;

import java.time.LocalDate;

public class BaseQualityStrategy implements QualityStrategy {
    @Override
    public int calculateQuality(Product product, LocalDate date) {
        return product.baseQuality;
    }
}
