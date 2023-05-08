package com.superdupermarket.app;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DeterioratingQualityStrategy extends BaseQualityStrategy {
    @Override
    public int calculateQuality(Product product, LocalDate date) {
        long daysBetween = ChronoUnit.DAYS.between(product.shelfDate, date);
        return (int) Math.max(super.calculateQuality(product, date) - daysBetween, 0);
    }
}